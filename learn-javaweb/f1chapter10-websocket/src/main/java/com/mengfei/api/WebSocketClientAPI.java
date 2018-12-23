package com.mengfei.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * author Alex
 * date 2018/12/23
 * description WebSocketClientAPI的Java API说明
 */
@ClientEndpoint
public class WebSocketClientAPI extends HttpServlet{
    private Session session;
    private String param;

    /**
     * 客户端API
     * 它基于ContainerProvider类和WebSocketContainer、RemoteEndpoint和Session接口构建
     * ContainerProvider提供了一个静态的getWebSocketContainer方法，用于获取底层WebSocket客户端实现
     * WebSocketContainer提供了对所有WebSocket客户端特性的访问
     * 它提供了4个重载的connectToServer方法，它们都接受一个URI，用于连接远程终端和初始化握手
     * 握手完成时，connectToServer方法将返回一个Session，通过Session对象可以关闭会话（关闭WebSocket连接）或者发送消息到远程服务端
     *
     * 另外，WebSocket的Endpoint有3个方法onOpen、onClose、和onError，它们将在这些事件发生时调用，而@ClientEndpoint类可以有标注
     * 了@OnOpen 、@OnClose和@OnError的方法，可以指定一个或多个标注了@OnMessage的方法，用于从远程终端接收消息。
     *
     * 注意：关于打开、关闭和错误事件，一个终端只能有一个方法分别用于处理它们；不过，它最多可以有三个消息处理方法：只能有一个用于处理
     * 文本消息、一个用于处理二进制消息、一个用于处理pong消息。
     */
    public void initClient() throws ServletException{
        param = this.getInitParameter("param");
        String path = this.getServletContext().getContextPath() + "/serverWebSocket/" + param;
        URI uri = null;
        try {
            uri = new URI("ws","localhost:8080",path,null,null);
            WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
            webSocketContainer.connectToServer(this,uri);
        } catch (URISyntaxException | IOException | DeploymentException e) {
            e.printStackTrace();
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @OnMessage
    public void onMessage(InputStream in){

    }

    @OnClose
    public void onClose(CloseReason reason){

    }
}
