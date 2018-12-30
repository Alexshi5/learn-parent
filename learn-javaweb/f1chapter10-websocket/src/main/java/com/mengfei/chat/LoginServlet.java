package com.mengfei.chat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * author Alex
 * date 2018/12/30
 * description 用于用户登录的Servlet
 */
@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("customer001", "customer001");
        userDatabase.put("customer002", "customer002");
        userDatabase.put("service001", "service001");
        userDatabase.put("service002", "service002");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout") != null)
        {
            session.invalidate();
            response.sendRedirect("login");
            return;
        }
        else if(session.getAttribute("username") != null)
        {
            request.getRequestDispatcher("/WEB-INF/jsp/product.jsp")
                    .forward(request, response);
            return;
        }

        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null)
        {
            request.getRequestDispatcher("/WEB-INF/jsp/product.jsp")
                    .forward(request, response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username == null || password == null ||
                !LoginServlet.userDatabase.containsKey(username) ||
                !password.equals(LoginServlet.userDatabase.get(username)))
        {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                    .forward(request, response);
        }
        else
        {
            session.setAttribute("username", username);
            request.changeSessionId();
            request.getRequestDispatcher("/WEB-INF/jsp/product.jsp")
                    .forward(request, response);
        }
    }
}
