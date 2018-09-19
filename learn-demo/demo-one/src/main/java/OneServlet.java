import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author Alex
 * date 2018/9/20
 * description
 */
@WebServlet(
        name = "oneServlet",
        urlPatterns = {"/demo1"},
        loadOnStartup = 1
)
public class OneServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/two/index.jsp");
    }
}
