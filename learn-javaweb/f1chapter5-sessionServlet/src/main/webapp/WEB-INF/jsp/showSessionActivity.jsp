<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Vector" %>
<%@ page import="f1.chapter5.pojo.PageVisit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请求记录</title>
</head>
<body>
<%!
    //声明一个处理显示时间的函数
    private String showTime(long time){
        String info = "";
        if(time < 1000){
            info = "小于1秒";
        }else if(time < 60*1000){
            info = time/1000 + "秒";
        }else if(time < 60*60*1000){
            info = time/(60*1000) + "分钟";
        }
        return info;
    }
%>
<%
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<h2>session属性</h2>
session id ：<%=session.getId()%><br>
session 是否未返回客户端：<%=session.isNew()%><br>
session 创建时间：<%=format.format(new Date(session.getCreationTime()))%><br>

<h2>session中的页面请求记录</h2>
<%
    Vector<PageVisit> visits = (Vector<PageVisit>) session.getAttribute("activity");

    for(PageVisit visit:visits){
        %>请求的url：<%=visit.getRequest()%><%
        if(null != visit.getIpAddress()){
            %> 发起请求的远程IP地址：<%=visit.getIpAddress().getHostAddress()%><%
        }
        %> 请求访问会话的时间：<%=format.format(new Date(visit.getEnteredTimestamp()))%><%
        if(null != visit.getLastTimestamp()){
            %> 请求停留时间：<%=showTime(visit.getLastTimestamp()-visit.getEnteredTimestamp())%><%
        }
        %><br><%
    }
%>
</body>
</html>
