package com.mengfei.api;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * author Alex
 * date 2018/12/23
 * description WebSocketServletAPI的Java API说明
 */
@ServerEndpoint("/serverWebSocket/{param}")
public class WebSocketServletAPI {

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

    }

    @OnClose
    public void onClose(Session session, @PathParam("param") String param){

    }

    @OnMessage
    public void onMessage(Session session, byte[] message){

    }
}
