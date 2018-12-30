<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>聊天室</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <style>
        #messageContainer {
            width: 300px;
            float: left;
        }
        #messageArea {
            height: 75px; width:280px;
        }
        #chatLog div.informational {
            font-style: italic;
            color: #AAA;
        }
        #chatLog div.error {
            font-weight: bold;
            color: #C00;
        }
        #chatLog span.user-me {
            font-weight: bold;
            color: #0A0;
        }
        #chatLog span.user-you {
            font-weight: bold;
            color: #55F;
        }
    </style>
</head>
<body>
<h1>聊天室</h1>
<div id="chatContainer">
    <div id="chatLog">

    </div>
    <div id="messageContainer">
        <textarea id="messageArea"></textarea>
    </div>
    <div id="buttonContainer">
        <button onclick="send();">发送消息</button>
        <button onclick="disconnect();">退出聊天</button>
    </div>
</div>
<div id="modalError" style="display: none">
    <div id="modalErrorBody">出现了一个异常</div>
</div>
<br>
<a href="login?logout=true">退出登录</a>
</body>
</html>
<script type="text/javascript" language="javascript">
    var send, disconnect;
    $(document).ready(function() {
        var modalError = $("#modalError");
        var modalErrorBody = $("#modalErrorBody");
        var chatLog = $('#chatLog');
        var messageArea = $('#messageArea');
        var username = '${sessionScope.username}';
        var otherJoined = false;

        if(!("WebSocket" in window)) {
            modalErrorBody.text('该浏览器不支持WebScoket通信，请更换其他浏览器继续尝试！');
            modalError.show();
            return;
        }

        var infoMessage = function(msg) {
            chatLog.append($('<div>').text(getFormatDate(new Date()) + ': ' + msg));
        };
        infoMessage('正在连接聊天终端服务器，请稍候......');

        var objectMessage = function(message) {
            var log = $('<div>');
            var date = message.timestamp == null ? '' : getFormatDate(new Date(message.timestamp));
            if(message.username != null) {
                var c = message.username == username ? 'user-me' : 'user-you';
                log.append($('<span>').addClass(c)
                    .text(date+' '+message.username+':\xA0'))
                    .append($('<span>').text(message.content));
            } else {
                log.addClass(message.type == 'ERROR' ? 'error' : 'informational')
                    .text(date + ' ' + message.content);
            }
            chatLog.append(log);
        };

        var server;
        try {
            server = new WebSocket('ws://' + window.location.host + '/chat/${chatSessionId}');
            server.binaryType = 'arraybuffer';
        } catch(error) {
            modalErrorBody.text(error);
            modalError.show();
            return;
        }

        server.onopen = function(event) {
            infoMessage('已经连接到聊天终端服务器');
        };

        server.onclose = function(event) {
            if(server != null)
                infoMessage('断开聊天终端服务器');
            server = null;
            if(!event.wasClean || event.code != 1000) {
                modalErrorBody.text('Code ' + event.code + ': ' + event.reason);
                modalError.show();
            }
        };

        server.onerror = function(event) {
            modalErrorBody.text(event.data);
            modalError.show();
        };

        server.onmessage = function(event) {
            if(event.data instanceof ArrayBuffer) {
                var message = JSON.parse(utf8ArrayBufferToStr(new Uint8Array(event.data)));
                objectMessage(message);
                if(message.type == 'JOINED') {
                    otherJoined = true;
                    if(username != message.username){
                        infoMessage('你当前正在与' + message.username + '聊天');
                    }
                }
            } else {
                modalErrorBody.text('意料之外的数据类型： [' + typeof(event.data) + ']');
                modalError.show();
            }
        };

        send = function() {
            if(server == null) {
                modalErrorBody.text('你没有连接到聊天终端服务器！');
                modalError.show();
            } else if(!otherJoined) {
                modalErrorBody.text('客服人员还没有加入聊天！');
                modalError.show();
            } else if(messageArea.get(0).value.trim().length > 0) {
                var message = {
                    timestamp: new Date().getTime(),
                    type: 'TEXT',
                    username: username,
                    content: messageArea.get(0).value
                };
                try {
                    var json = JSON.stringify(message);
                    var buffer = utf8StrToArrayBuffer(json);
                    server.send(buffer);
                    messageArea.get(0).value = '';
                } catch(error) {
                    modalErrorBody.text(error);
                    modalError.show();
                }
            }
        };

        disconnect = function() {
            if(server != null) {
                infoMessage('已断开聊天终端服务器！');
                server.close();
                server = null;
                window.location.href = "chat?action";
            }
        };

        window.onbeforeunload = disconnect;
    });

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

    //ArrayBuffer转换成utf-8编码格式的字符串，参数为ArrayBuffer对象
    function utf8ArrayBufferToStr(array) {
        var out, i, len, c;
        var char2, char3;
        out = "";
        len = array.length;
        i = 0;
        while(i < len) {
            c = array[i++];
            switch(c >> 4)
            {
                case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                    // 0xxxxxxx
                    out += String.fromCharCode(c);
                    break;
                case 12: case 13:
                    // 110x xxxx 10xx xxxx
                    char2 = array[i++];
                    out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
                    break;
                case 14:
                    // 1110 xxxx 10xx xxxx 10xx xxxx
                    char2 = array[i++];
                    char3 = array[i++];
                    out += String.fromCharCode(((c & 0x0F) << 12) |
                        ((char2 & 0x3F) << 6) |
                        ((char3 & 0x3F) << 0));
                    break;
            }
        }
        return out;
    }

    //字符串转为ArrayBuffer对象，参数为字符串
    function utf8StrToArrayBuffer(str) {
        var buf = new ArrayBuffer(str.length*2); // 每个字符占用2个字节
        var bufView = new Uint16Array(buf);
        for (var i=0, strLen=str.length; i<strLen; i++) {
            bufView[i] = str.charCodeAt(i);
        }
        return buf;
    }

</script>
