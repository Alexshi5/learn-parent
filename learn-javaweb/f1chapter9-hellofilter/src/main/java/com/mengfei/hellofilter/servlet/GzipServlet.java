package com.mengfei.hellofilter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author Alex
 * date 2018/11/12
 * description 一个转发压缩请求的Servlet
 */
@WebServlet(
        name = "gzipServlet",
        urlPatterns = {"/gzip"}
)
public class GzipServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream()
                .println("This is GzipServlet");
    }
}
