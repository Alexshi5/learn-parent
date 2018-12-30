<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<c:if test="${loginFailed}">
    账号或密码错误，请重新尝试！
</c:if>
<form method="post" action="login">
    用户：<input name="username"><br>
    密码：<input name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
