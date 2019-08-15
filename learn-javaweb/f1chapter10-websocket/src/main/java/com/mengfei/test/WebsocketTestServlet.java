package com.mengfei.test;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "websocketTestServlet",urlPatterns = "/test")
public class WebsocketTestServlet extends HttpServlet {
    private static final long serialVersionUID = 8579944495322145447L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        if(!StringUtils.isEmpty(param)){
            request.setAttribute("param", param);
            request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
        }
    }
}
