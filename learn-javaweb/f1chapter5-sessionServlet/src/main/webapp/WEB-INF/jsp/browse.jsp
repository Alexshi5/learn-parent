<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<h2>商品展示列表</h2>
<%
    Map<Integer,String> products = (Map<Integer,String>) request.getAttribute("products");
    for(Integer id:products.keySet()){

        %><a href="<c:url value="/shop">
            <c:param name="action" value="addToCart"/>
            <c:param name="productId" value="<%=id.toString()%>"/>
        </c:url>"><%=products.get(id)%><br></a><%
    }
%>
<br>
<h2>
    <a href="<c:url value="/shop?action=showCart"/>">购物车</a>
</h2>
<br>
<h2>
    <a href="login?logout=true">注销</a>
</h2>
</body>
</html>
