package com.mengfei.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Map;

/**
 * author Alex
 * date 2018/12/23
 * description WebSocketServletAPI的Java API说明
 */
@ServerEndpoint("/serverWebSocketTest/{param}")
public class WebSocketServerTest {

    class Message implements Serializable {
        private static final long serialVersionUID = -7080632117633881039L;
        private Timestamp timestamp;
        private String content;
        private String username;

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    private static final Map<String, Session> sessions = new Hashtable<>();

    /**
     * 服务端API
     * 服务器API依赖于完整的客户端API，ServerContainer继承了WebSocketContainer，它添加了通过编程方式注册ServerEndpointConfig实例
     * 的方法和标注了@ServerEndpoint的类。在Servlet环境中，调用ServletContext.getAttribute("javax.websocket.server.ServerContainer")
     * 可以获得ServerContainer实例。如果是在独立运行的程序中，需要按照特定WebSocket实现的指令获得ServletContainer实例。不过，几乎在
     * 所有的Java EE用例中你都不需要获得ServerContainer，你只需要使用@ServerEndpoint标注服务器终端类即可，WebSocket实现可以扫描类
     * 的注解，并自动选择和注册服务器终端。容器将在每次收到WebSocket连接时创建对应终端类的实例，在连接关闭之后再销毁该实例。在使用@ServerEndpoint
     * 时，至少需要指定必须的value特性，它表示该终端可以做出响应的应用程序相对的URL，该URL路径必须以斜杠开头，并可以包含模板参数，
     * 比如：@ServerEndpoint("/serverWebSocket/{param}")
     * 然后，服务器终端中的所有@OnOpen 、@OnClose和@OnError或者@OnMessage方法都可以使用@PathParam("param")标注一个可选的额外参数
     *
     * 服务器终端中的事件处理方法将如同客户端终端中的事件处理方法一样工作，服务器和客户端的区别只在握手的时候。在握手完成，连接建立之后，
     * 服务器和客户端都将变成工作端点，并且是具有相同能力、责任完全对等的终端。
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("param") String param){
        Message message = new Message();
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        try {
            if(session != null && !StringUtils.isEmpty(param)){
                sessions.put("param" + param, session);
                if(param.equals("1")){
                    message.setUsername("user");
                    message.setContent("user加入会话");
                    session.getBasicRemote().sendText(JSON.toJSONString(message));
                } else if(param.equals("2")){
                    Session session1 = sessions.get("param1");
                    message.setUsername("service");
                    message.setContent("service加入会话");
                    session.getBasicRemote().sendText(JSON.toJSONString(message));
                    if(session1 != null){
                        session1.getBasicRemote().sendText(JSON.toJSONString(message));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            try {
                session.getBasicRemote().sendText(e.getMessage());
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("param") String param){
        try {
            if(session != null){
                sessions.remove("param" + param);
                session.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String message){
        try {
            Session session1 = sessions.get("param1");
            Session session2 = sessions.get("param2");
            if(session1 != null){
                session1.getBasicRemote().sendText(message);
            }
            if(session2 != null){
                session2.getBasicRemote().sendText(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
