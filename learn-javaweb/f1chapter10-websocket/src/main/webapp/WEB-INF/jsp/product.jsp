<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>商品列表</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<h1>商品列表</h1>
<h3>衣服</h3>
<h3>鞋子</h3>
<h3>外套</h3>
<c:if test="${fn:contains(sessionScope.username,'service')}">
    <br>
    <a href="chat?action=list">查看会话列表</a>
</c:if>
<c:if test="${fn:contains(sessionScope.username,'customer')}">
    <br>
    <a href="javascript:void(0)" onclick="newChat()">联系客服</a>
</c:if>
<br>
<a href="login?logout=true">退出登录</a>
</body>
</html>
<script>
    function newChat() {
        hiddenFormSubmit('chat',{action:'new'});
    }
    function hiddenFormSubmit(url,fields) {
        var form = $('<form id="mapForm" method="post"></form>')
            .attr({ action: url, style: 'display: none;' });
        for(var key in fields) {
            if(fields.hasOwnProperty(key))
                form.append($('<input type="hidden">').attr({
                    name: key, value: fields[key]
                }));
        }
        $('body').append(form);
        form.submit();
    }
</script>
