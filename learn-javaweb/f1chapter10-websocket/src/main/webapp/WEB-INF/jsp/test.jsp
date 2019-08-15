<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<body>
<h1>WebSocket测试页面</h1>
<div>
    <h2 id="title"></h2>
    <input id="msg" value="">
    <button onclick="send()">发送消息</button>
    <p id="info">

    </p>
    <button onclick="disconnect()">断开服务器</button>
</div>
</body>
</html>
<script>
    var param = ${requestScope.param};
    $('#title').text(param == '1'?'用户':'客服');
    var server,disconnect;
    try {
        server = new WebSocket('ws://' + window.location.host + '/serverWebSocketTest/' + param);
        server.binaryType = 'arraybuffer';
    }catch (e) {
        console.log("连接异常，异常信息：" + e);
    }

    server.onopen = function(event) {
        console.log("连接到服务器...");
        $('#info').append("连接到服务器..." + "<br>");
    };

    server.onclose = function(event) {
        if(server != null){
            console.log("断开服务器...");
            $('#info').append("断开服务器..." + "<br>");
        }
        server = null;
        if(!event.wasClean || event.code != 1000) {
            console.log("断开服务器异常");
            $('#info').append("断开服务器异常..." + "<br>");
        }
    };

    server.onerror = function(event) {
        console.log("未知异常...");
        $('#info').append("未知异常..." + "<br>");
    };

    server.onmessage = function(event) {
        var resultData = event.data;
        console.log(resultData);
        var data = JSON.parse(resultData);
        var span = '';
        if(data.username.indexOf('user')!==-1){
            span = "<span style='color: red'>" + getFormatDate(new Date(data.timestamp)) + " " + data.content + "</span>";
        }else {
            span = "<span style='color: green'>" + getFormatDate(new Date(data.timestamp)) + " " + data.content + "</span>";
        }
        $('#info').append(span + "<br>");
    };

    send = function() {
        if(server == null) {
            console.log("发送消息失败，没有连接到服务器");
        } else {
            var message = {
                timestamp: new Date().getTime(),
                username: param == '1'? "user" : "service",
                content: $('#msg').val()
            };
            $('#msg').val('');
            try {
                var json = JSON.stringify(message);
                server.send(json);
            } catch(error) {
                console.log("发送消息失败，异常信息：" + error);
                $('#info').append("发送消息失败，异常信息：" + error + "<br>");
            }
        }
    };

    disconnect = function() {
        if(server != null) {
            console.log("已断开服务器...");
            $('#info').append("已断开服务器..." + "<br>");
            server.close();
            server = null;
        }
    };

    window.onbeforeunload = disconnect;

    function getFormatDate(date) {
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if(month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if(strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }

        var hour = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        if(hour >= 1 && hour <= 9) {
            hour = "0" + hour;
        }
        if(minutes >= 0 && minutes <= 9) {
            minutes = "0" + minutes;
        }
        if(seconds >= 0 && seconds <= 9) {
            seconds = "0" + seconds;
        }

        var currentdate = date.getFullYear() + "-" + month + "-" + strDate +
            " " + hour + ":" + minutes + ":" + seconds;
        return currentdate;
    }

    /**
     * 按Enter键时发送消息
     * @param event
     */
    document.onkeyup = function(event){
         var e = event || window.event || arguments.callee.caller.arguments[0];
         if(e && e.keyCode==13){ // enter 键
             send();
         }
    }
</script>