package com.mengfei.chat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * author Alex
 * date 2018/12/30
 * description 聊天服务器终端
 */
@ServerEndpoint(value = "/chat/{chatSessionId}",
                encoders = ChatMessageCodec.class,
                decoders = ChatMessageCodec.class,
                configurator = ChatEndpoint.EndpointConfigurator.class)
@WebListener
public class ChatEndpoint implements HttpSessionListener{
    //HTTP会话的键
    private static String HTTP_SESSION_PROPERTY = "http_session";
    //WebSocket会话的键
    private static String WEBSOCKET_SESSION_PROPERTY = "websocket_session";
    //聊天会话序列ID
    private static long chatSessionIdSequence = 1L;
    //聊天会话序列ID的同步锁
    private static final Object chatSessionIdSequenceLock = new Object();
    //聊天会话的Map集合，以会话序列ID为键
    private static final Map<Long,ChatSession> chatSessions = new Hashtable<>();
    //与WebSocket会话关联的聊天会话Map集合，以WebSocket会话对象为键
    private static final Map<Session,ChatSession> sessions = new Hashtable<>();
    //与WebSocket会话关联的HttpSession会话Map集合，以WebSocket会话对象为键
    private static final Map<Session,HttpSession> httpSessions = new Hashtable<>();
    //等待聊天会话列表
    public static final List<ChatSession> waitingChatSessionList = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("chatSessionId") long chatSessionId){
        //从WebSocket会话的的配置属性中获取设置的HttpSession对象
        HttpSession httpSession = (HttpSession)session.getUserProperties().get(HTTP_SESSION_PROPERTY);
        try {
            //检查httpSession是否为空，以及用户是否登录
            if(httpSession == null || httpSession.getAttribute("username") == null){
                //关闭WebSocket会话
                session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY,"请先登录！"));
                return;
            }
            String username = (String)httpSession.getAttribute("username");
            //向WebSocket会话的属性中设置用户名
            session.getUserProperties().put("username",username);

            //创建消息对象
            ChatMessage message = new ChatMessage();
            message.setTimestamp(new Date());
            message.setUsername(username);

            ChatSession chatSession;
            if(chatSessionId == 0){//请求创建新的聊天会话，并添加到等待会话列表中
                message.setType(ChatMessage.Type.STARTED);
                message.setContent(username + "启动聊天会话");

                chatSession = new ChatSession();
                //添加单机环境的同步块
                synchronized (ChatEndpoint.chatSessionIdSequenceLock){
                    chatSession.setChatSessionId(ChatEndpoint.chatSessionIdSequence++);
                }
                chatSession.setCustomer(session);
                chatSession.setCustomerUsername(username);
                chatSession.setCreationMessage(message);

                ChatEndpoint.waitingChatSessionList.add(chatSession);
                ChatEndpoint.chatSessions.put(chatSession.getChatSessionId(),chatSession);
            }else {//客服将被加入到请求的会话中，消息也将同时发送到两个客户端
                message.setType(ChatMessage.Type.JOINED);
                message.setContent(username + "加入聊天会话");

                //通过chatSessionId从聊天会话集合中获取聊天会话对象
                chatSession = ChatEndpoint.chatSessions.get(chatSessionId);
                chatSession.setCustomerService(session);
                chatSession.setCustomerServiceUsername(username);
                //移除等待聊天会话列表中的对象
                ChatEndpoint.waitingChatSessionList.remove(chatSession);
                //给客服人员推送消息
                session.getBasicRemote().sendObject(chatSession.getCreationMessage());
                session.getBasicRemote().sendObject(message);
            }

            ChatEndpoint.sessions.put(session,chatSession);
            ChatEndpoint.httpSessions.put(session,httpSession);
            //在当前的HTTP请求会话属性中添加关联的WebSocket会话
            this.getSessionsForHttpSession(httpSession).add(session);
            chatSession.log(message);
            //给客户推送消息
            chatSession.getCustomer().getBasicRemote().sendObject(message);
        }catch (IOException | EncodeException e){
            this.onError(session, e);
        }
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage message)
    {
        //通过WebSocket会话来获取聊天会话
        ChatSession c = ChatEndpoint.sessions.get(session);
        //通过聊天会话来获取聊天的另外一个参与者
        Session other = this.getOtherSession(c, session);
        if(c != null && other != null)
        {
            c.log(message);
            try
            {
                //向两边发送消息
                session.getBasicRemote().sendObject(message);
                other.getBasicRemote().sendObject(message);
            }
            catch(IOException | EncodeException e)
            {
                this.onError(session, e);
            }
        }
    }

    //WebSocket会话关闭
    @OnClose
    public void onClose(Session session, CloseReason reason)
    {
        if(reason.getCloseCode() == CloseReason.CloseCodes.NORMAL_CLOSURE)
        {
            ChatMessage message = new ChatMessage();
            message.setUsername((String)session.getUserProperties().get("username"));
            message.setType(ChatMessage.Type.LEFT);
            message.setTimestamp(new Date());
            message.setContent(message.getUsername() + "退出聊天");
            try
            {
                Session other = this.close(session, message);
                if(other != null){
                    other.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    @OnError
    public void onError(Session session, Throwable e)
    {
        ChatMessage message = new ChatMessage();
        message.setUsername((String)session.getUserProperties().get("username"));
        message.setType(ChatMessage.Type.ERROR);
        message.setTimestamp(new Date());
        message.setContent(message.getUsername() + "由于出现异常退出聊天");
        try
        {
            Session other = this.close(session, message);
            if(other != null)
                other.close(new CloseReason(
                        CloseReason.CloseCodes.UNEXPECTED_CONDITION, e.toString()
                ));
        }
        catch(IOException ignore) { }
        finally
        {
            try
            {
                session.close(new CloseReason(
                        CloseReason.CloseCodes.UNEXPECTED_CONDITION, e.toString()
                ));
            }
            catch(IOException ignore) { }
        }
    }

    //HttpSession会话销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent event)
    {
        HttpSession httpSession = event.getSession();
        if(httpSession.getAttribute(WEBSOCKET_SESSION_PROPERTY) != null)
        {
            ChatMessage message = new ChatMessage();
            message.setUsername((String)httpSession.getAttribute("username"));
            message.setType(ChatMessage.Type.LEFT);
            message.setTimestamp(new Date());
            message.setContent(message.getUsername() + "退出登录");
            for(Session session:new ArrayList<>(this.getSessionsForHttpSession(httpSession)))
            {
                try
                {
                    session.getBasicRemote().sendObject(message);
                    Session other = this.close(session, message);
                    if(other != null){
                        other.close();
                    }
                }
                catch(IOException | EncodeException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        session.close();
                    }
                    catch(IOException ignore) { }
                }
            }
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) { /* do nothing */ }

    @SuppressWarnings("unchecked")
    private synchronized ArrayList<Session> getSessionsForHttpSession(HttpSession httpSession)
    {
        try
        {
            //一个HttpSession可能关联多个WebSocket会话
            if(httpSession.getAttribute(WEBSOCKET_SESSION_PROPERTY) == null)
                httpSession.setAttribute(WEBSOCKET_SESSION_PROPERTY, new ArrayList<>());

            return (ArrayList<Session>)httpSession.getAttribute(WEBSOCKET_SESSION_PROPERTY);
        }
        catch(IllegalStateException e)
        {
            return new ArrayList<>();
        }
    }

    private Session close(Session s, ChatMessage message)
    {
        ChatSession c = ChatEndpoint.sessions.get(s);
        Session other = this.getOtherSession(c, s);
        ChatEndpoint.sessions.remove(s);
        HttpSession h = ChatEndpoint.httpSessions.get(s);
        if(h != null){
            this.getSessionsForHttpSession(h).remove(s);
        }
        if(c != null)
        {
            c.log(message);
            ChatEndpoint.waitingChatSessionList.remove(c);
            ChatEndpoint.chatSessions.remove(c.getChatSessionId());
            try
            {
                c.writeChatLog(new File("D:/logs/chat." + c.getChatSessionId() + ".log"));
            }
            catch(Exception e)
            {
                System.err.println("无法写入聊天日志信息！");
                e.printStackTrace();
            }
        }
        if(other != null)
        {
            ChatEndpoint.sessions.remove(other);
            h = ChatEndpoint.httpSessions.get(other);
            if(h != null){
                this.getSessionsForHttpSession(h).remove(s);
            }
            try
            {
                other.getBasicRemote().sendObject(message);
            }
            catch(IOException | EncodeException e)
            {
                e.printStackTrace();
            }
        }
        return other;
    }

    //通过当前聊天会话中的参与者来获取另外一个参与者的WebSocket会话
    private Session getOtherSession(ChatSession c, Session s)
    {
        return c == null ? null :
                (s == c.getCustomer() ? c.getCustomerService() : c.getCustomer());
    }

    public static class EndpointConfigurator extends ServerEndpointConfig.Configurator{
        @Override
        public void modifyHandshake(ServerEndpointConfig config,
                                    HandshakeRequest request,
                                    HandshakeResponse response) {
            super.modifyHandshake(config, request, response);
            //从底层的HTTP请求中获取到HttpSession对象，并设置到当前WebSocket会话的的配置属性中
            config.getUserProperties().put(HTTP_SESSION_PROPERTY,request.getHttpSession());
        }
    }
}
