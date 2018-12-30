package com.mengfei.chat;

import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author Alex
 * date 2018/12/29
 * description 主要是管理聊天会话的显示、创建和加入，方法Post设置了Expires和Cache-Control头，
 * 用于保证浏览器不会缓存该聊天页面
 */
@WebServlet(name = "chatServlet",urlPatterns = "/chat")
public class ChatServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("list".equals(action))
        {
            request.setAttribute("waitingChatSessionList", ChatEndpoint.waitingChatSessionList);
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp")
                    .forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/product.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Expires", "Thu, 1 Jan 1970 12:00:00 GMT");
        response.setHeader("Cache-Control","max-age=0, must-revalidate, no-cache");

        String action = request.getParameter("action");
        String view = null;
        switch(action)
        {
            case "new":
                //客户发起的会话请求，即新创建的聊天会话ID均设为0
                request.setAttribute("chatSessionId", 0);
                view = "chat";
                break;
            case "join":
                String id = request.getParameter("chatSessionId");
                if(id == null || !NumberUtils.isDigits(id))
                    response.sendRedirect("chat?list");
                else
                {
                    request.setAttribute("chatSessionId", Long.parseLong(id));
                    view = "chat";
                }
                break;
            default:
                request.getRequestDispatcher("/WEB-INF/jsp/product.jsp")
                        .forward(request, response);
                break;
        }

        if(view != null) {
            request.getRequestDispatcher("/WEB-INF/jsp/" + view + ".jsp")
                    .forward(request, response);
        }
    }
}
