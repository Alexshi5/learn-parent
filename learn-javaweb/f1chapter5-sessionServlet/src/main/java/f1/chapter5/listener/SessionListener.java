package f1.chapter5.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author Alex
 * date 2018/10/28
 * description 用于监测会话状态的变化
 */
@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionIdListener{

    /**
     * 格式化时间
     * @return
     */
    private String showTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent e, String oldSessionId) {
        //当会话id改变时，添加会话活动日志
        System.out.println(showTime() + " 会话id已改变，oldSessionId=" + oldSessionId + "，newSessionId=" + e.getSession().getId());
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        //当会话创建时，添加会话活动日志
        System.out.println(showTime() + " 会话已创建，sessionId=" + e.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        //当会话注销时，添加会话活动日志
        System.out.println(showTime() + " 会话已销毁，销毁的sessionId=" + e.getSession().getId());
    }
}
