package com.mengfei.chat;

import javax.servlet.annotation.WebListener;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

/**
 * author Alex
 * date 2018/12/30
 * description 聊天服务器终端
 */
@ServerEndpoint(value = "/chat/${sessionId}",
                encoders = ChatMessageCodec.class,
                decoders = ChatMessageCodec.class,
                configurator = ChatEndpoint.EndpointConfigurator.class)
@WebListener
public class ChatEndpoint {
    //HTTP会话集合的键
    private static String HTTP_SESSION_PROPERTY = "http_session";
    //WebSocket会话集合的键
    private static String WEBSOCKET_SESSION_PROPERTY = "websocket_session";

    public static class EndpointConfigurator extends ServerEndpointConfig.Configurator{
        @Override
        public void modifyHandshake(ServerEndpointConfig config,
                                    HandshakeRequest request,
                                    HandshakeResponse response) {
            super.modifyHandshake(config, request, response);
            //从底层的HTTP请求中获取到HttpSession对象，并设置到当前请求的配置属性中
            config.getUserProperties().put(HTTP_SESSION_PROPERTY,request.getHttpSession());
        }
    }
}
