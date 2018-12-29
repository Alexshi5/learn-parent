package com.mengfei.cluster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * author Alex
 * date 2018/12/23
 * description WebSocket通信的客户终端
 * 任何类都可以是终端，这里使用了Servlet，因为它简单方便，方法init将在第一个请求到达时调用，用于连接服务器端，
 * 方法destroy用于关闭连接，每次请求进入的时候，Servlet将会向集群发送关于它的信息，方法onMessage将接受来自
 * 其他集群节点回复的消息，而onClose将在连接异常关闭时打印出错误的消息。
 */
@ClientEndpoint
public class ClusterNodeServlet extends HttpServlet{
    private Session session;
    private String nodeId;

    @Override
    public void init() throws ServletException {
        nodeId = this.getInitParameter("nodeId");
        String path = this.getServletContext().getContextPath() + "/clusterNode/" + nodeId;
        try {
            URI uri = new URI("ws","localhost:8082",path,null,null);
            //获取WebSocket容器
            WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
            //通过WebSocket容器连接到服务端并获取session
            session = webSocketContainer.connectToServer(this, uri);
        } catch (URISyntaxException | DeploymentException | IOException e) {
            throw new ServletException("不能够连接到" + path ,e);
        }
    }

    @Override
    public void destroy() {
        try {
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ClusterMessage clusterMessage = new ClusterMessage(nodeId,"信息 - 请求IP：" +
        req.getRemoteAddr() + "，请求参数：" + req.getQueryString());
        //获取对象输出流ObjectOutputStream，它可以将对象的原始数据写入OutputStream，可以使用流的方式来实现对象的持久存储
        //如果是套接字流，则可以在另一个主机上使用ObjectInputStream进行对象重构
        try (OutputStream output = this.session.getBasicRemote().getSendStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(output)) {
            outputStream.writeObject(clusterMessage);
        }
        resp.getWriter().append("OK");
    }

    @OnMessage
    public void onMessage(InputStream inputStream){
        //获取对象输入流ObjectInputStream，进行对象重构
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            ClusterMessage message = (ClusterMessage)objectInputStream.readObject();
            System.out.println("信息 - 当前节点：" + nodeId + "，消息来自节点" +
                    message.getNodeId() + "，消息是：" + message.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(CloseReason reason){
        CloseReason.CloseCode code = reason.getCloseCode();
        if(code != CloseReason.CloseCodes.NORMAL_CLOSURE){
            System.out.println("错误 - WebSocket关闭异常！");
        }
    }
}
