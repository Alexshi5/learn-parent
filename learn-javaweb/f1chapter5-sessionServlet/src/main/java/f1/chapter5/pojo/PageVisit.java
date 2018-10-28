package f1.chapter5.pojo;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * author Alex
 * date 2018/10/28
 * description 用于记录页面请求相关参数的实体类
 */
public class PageVisit implements Serializable{

    private static final long serialVersionUID = 2470743552696749915L;

    //页面请求的访问时间
    private Long enteredTimestamp;

    //页面请求的结束时间
    private Long lastTimestamp;

    //请求的url和参数拼接字符串
    private String request;

    //请求的远程地址对象
    private InetAddress ipAddress;

    public Long getEnteredTimestamp() {
        return enteredTimestamp;
    }

    public void setEnteredTimestamp(Long enteredTimestamp) {
        this.enteredTimestamp = enteredTimestamp;
    }

    public Long getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Long lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}
