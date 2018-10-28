package f1.chapter5.pojo;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * author Alex
 * date 2018/10/28
 * description 会话注册表
 */
public final class SessionRegistry {

    private static final Map<String,HttpSession> SESSION_MAP = new Hashtable<>();

    //将构造方法设置为私有，禁止创建该对象的实例
    private SessionRegistry(){}

    public static void addSession(HttpSession session){
        SESSION_MAP.put(session.getId(),session);
    }

    public static void updateSession(HttpSession session,String oldSessionId){
        //添加同步块
        synchronized (SESSION_MAP){
            SESSION_MAP.remove(oldSessionId);
            addSession(session);
        }
    }

    public static void removeSession(HttpSession session){
        SESSION_MAP.remove(session.getId());
    }

    public static List<HttpSession> getAllSession(){
        return new ArrayList<>(SESSION_MAP.values());
    }

    public static int getNumberOfSession(){
        return SESSION_MAP.size();
    }
}
