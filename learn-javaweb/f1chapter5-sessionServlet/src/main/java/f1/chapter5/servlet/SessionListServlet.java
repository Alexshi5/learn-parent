package f1.chapter5.servlet;

import f1.chapter5.pojo.SessionRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * author Alex
 * date 2018/10/28
 * description 处理展示活跃会话列表的请求
 */
@WebServlet(
        name = "sessionListServlet",
        urlPatterns = "/sessionList"
)
public class SessionListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(null == session.getAttribute("username")){
            response.sendRedirect("login");
            return;
        }

        request.setAttribute("numberOfSession", SessionRegistry.getNumberOfSession());

        request.setAttribute("sessionList",SessionRegistry.getAllSession());

        request.getRequestDispatcher("/WEB-INF/jsp/sessionList.jsp").forward(request,response);
    }
}
