<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h2>登录</h2>
<br>
<%
    Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
    if(loginFailed){
        out.print("账号或密码错误，请重新尝试登录！");
    }
%>
<br>
<form method="post" action="login">
    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="登录">
</form>
<br>
<h2>
    <a href="login?logout=true">注销</a>
</h2>
</body>
</html>
