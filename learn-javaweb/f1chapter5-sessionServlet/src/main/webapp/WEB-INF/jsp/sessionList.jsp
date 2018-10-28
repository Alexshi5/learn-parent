<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>活跃的会话列表</title>
</head>
<body>
<h2>
    <a href="login?logout=true">注销</a>
</h2>
<br>
<h2>活跃的会话列表</h2>
在这个应用程序中，现在总共有<%=request.getAttribute("numberOfSession")%>个会话存活
<br>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<HttpSession> sessionList = (List<HttpSession>) request.getAttribute("sessionList");
    long nowTime = System.currentTimeMillis();
    for(HttpSession session1:sessionList){
        out.print("用户名：" + session1.getAttribute("username"));
        if(session1.getId().equals(session.getId())){
            out.print("(你自己)");
        }
        out.print(" sessionId=" + session1.getId() + "，该会话最后访问时间是：" + format.format(new Date(session1.getLastAccessedTime())));
        out.print("<br>");
    }
%>
</body>
</html>
