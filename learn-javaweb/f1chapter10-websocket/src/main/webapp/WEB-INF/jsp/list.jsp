<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>会话列表</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<h1>会话列表</h1>
<c:if test="${fn:length(waitingChatSessionList) == 0}">
    没有等待的客户会话请求！<br>
</c:if>
<c:if test="${fn:length(waitingChatSessionList) > 0}">
    <c:forEach items="${waitingChatSessionList}" var="s">
        <a href="javascript:void(0)" onclick="joinChat(${s.chatSessionId});">${s.customerUsername}</a>
    </c:forEach>
</c:if>
<br>
<a href="login?logout=true">退出登录</a>
</body>
</html>
<script>
    function joinChat(chatSessionId) {
        hiddenFormSubmit('chat',{action:'join',chatSessionId:chatSessionId});
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
