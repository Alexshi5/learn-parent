package f1.chapter5.servlet;

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
 * date 2018/10/28
 * description 用于控制用户的登录和注销
 */
@WebServlet(
        name = "loginServlet",
        urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet{

    //模拟一个静态的、存在于内存之中的用户数据库
    private static final Map<String,String> userMap = new Hashtable<>();

    static {
        userMap.put("zhangsan","zhangsan001");
        userMap.put("lisi","lisi001");
        userMap.put("wangwu","wangwu001");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //如果是注销操作，则重定向到登录页面
        String logout = request.getParameter("logout");
        if(null != logout && logout.equals("true")){
            session.invalidate();
            response.sendRedirect("login");
            return;
        }

        //用于显示登录页面
        if(null == session.getAttribute("username")){
            //未登录的跳转到登录页面
            request.setAttribute("loginFailed",false);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }else {
            //已经登录的跳转到商品列表页面
            response.sendRedirect("shop");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用于验证表单提交
        HttpSession session = request.getSession();
        if(null == session.getAttribute("username")){
            //未登录要进行验证
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(null == username || null == password || !userMap.containsKey(username) || !userMap.get(username).equals(password)){
                //账号或密码验证错误的将loginFailed置为true
                request.setAttribute("loginFailed",true);
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            }else {
                session.setAttribute("username",username);
                //登录成功后，改变sessionId
                request.changeSessionId();
                //跳转到商品列表页面
                response.sendRedirect("shop");
            }
        }else {
            //已经登录的跳转到商品列表页面
            response.sendRedirect("shop");
        }
    }
}
