package f1.chapter3.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "helloServlet",
        urlPatterns = {"/getting"},
        loadOnStartup = 1
)
public class HelloServlet1 extends HttpServlet{
    private static final String USER_NAME="Tom";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(null==username){
            username=HelloServlet1.USER_NAME;
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>")
              .append("<html><head>")
              .append("<title>测试</title>")
              .append("</head>")
              .append("<body>Hello ").append(username+"<br/>")
              .append("Enter your name:<br/>")
              .append("<form action=\"/getting\" method=\"post\"> ")
              .append("<input name=\"username\" type=\"text\"/><br/>")
              .append("<input type=\"submit\"/></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
