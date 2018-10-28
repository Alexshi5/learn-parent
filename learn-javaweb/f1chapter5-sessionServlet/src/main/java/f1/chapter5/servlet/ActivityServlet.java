package f1.chapter5.servlet;

import f1.chapter5.pojo.PageVisit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

/**
 * author Alex
 * date 2018/10/28
 * description 用于接收记录或查看session活动的请求
 */
@WebServlet(
        name = "activityServlet",
        urlPatterns = "/do/*"
)
public class ActivityServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        recordSessionActivity(req);

        showSessionActivity(req,resp);
    }

    /**
     * 请求的转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showSessionActivity(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/jsp/showSessionActivity.jsp").forward(request,response);
    }

    /**
     * 获取到会话，如果会话中存在请求记录就写入最后一个请求记录的页面请求结束时间，之后向vector中添加新的请求记录
     * @param request
     */
    private void recordSessionActivity(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session.getAttribute("activity")){
            session.setAttribute("activity",new Vector<PageVisit>());
        }

        Vector<PageVisit> visits = (Vector<PageVisit>) session.getAttribute("activity");

        if(!visits.isEmpty()){
            PageVisit lastElement = visits.lastElement();
            lastElement.setLastTimestamp(System.currentTimeMillis());
        }

        PageVisit pageVisit = new PageVisit();
        pageVisit.setEnteredTimestamp(System.currentTimeMillis());
        if(null == request.getQueryString()){
            pageVisit.setRequest(request.getRequestURI());
        }else {
            //请求参数不为空时，将参数拼接到url中
            pageVisit.setRequest(request.getRequestURI()+"?"+request.getQueryString());
        }

        String remoteAddr = request.getRemoteAddr();
        try {
            InetAddress inetAddress = InetAddress.getByName(remoteAddr);
            pageVisit.setIpAddress(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        visits.add(pageVisit);
    }
}
