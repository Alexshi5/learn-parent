<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<h2>购物车展示列表</h2>
<%
    Map<Integer,String> products = (Map<Integer,String>)request.getAttribute("products");

    Map<Integer,Integer> cart = (Map<Integer,Integer>)session.getAttribute("cart");

    if(null == cart || cart.size() ==0){
        %>购物车为空<%
    }else {
        for(Integer id:cart.keySet()){
            %>商品名：<%=products.get(id)%> 数量：<%=cart.get(id)%><br><%
        }
    }
%>
<br>
<h2>
    <a href="<c:url value="/shop"/>">商品展示列表</a>
</h2>
<h2>
    <a href="<c:url value="/shop?action=clearCart"/>">清空购物车</a>
</h2>
</body>
</html>
