package f1.chapter3.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "servletParamServlet",
        urlPatterns = {"/servletParam"},
        initParams = {@WebInitParam(name = "password", value = "Tom123")},
        loadOnStartup = 1
)
public class ServletParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();//获取当前的Servlet配置
        PrintWriter writer = resp.getWriter();
        writer.print(servletConfig.getInitParameter("password"));
    }
}
