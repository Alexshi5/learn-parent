<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>

</head>
<script type="text/javascript"  src="/js/jquery.min.js"></script>
<body>
<h2>Hello Project One</h2>
</body>
</html>
<script>
    $(function () {
        $.get('test/cluster',{},function (data) {
            console.log(data);
        },'json');
    });
</script>
