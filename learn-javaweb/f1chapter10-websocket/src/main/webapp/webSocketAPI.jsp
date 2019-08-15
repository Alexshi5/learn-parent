<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Hello WebSocket!</h2>
</body>
</html>
<script>
    /**
     * 创建websocket对象
     */
    var connection1 = new WebSocket("ws://localhost:8090/websocket");
    var connection2 = new WebSocket("wss://localhost:8090/websocket");
    var connection3 = new WebSocket("wss://localhost:8090/websocket","char:v1");

    /**
     * websocket对象的属性
     */
    //属性readyState：表示当前WebSocket连接的状态，它的值是CONNECTING(0),OPEN(1),CLOSING(2),CLOSED(3)中的一个
    if(connection1.readyState === WebSocket.OPEN){
        //do something
    }
    //属性binaryType：通常应该在实例化WebSocket对象之后就立即设置binaryType属性，并在连接剩下的时间内一直使用该类型
    connection1.binaryType = 'arraybuffer';
    //属性bufferdAmount：表示之前的send调用还有多少数据需要发送到服务器

    /**
     * websocket对象的事件
     */
    //4种不同的事件
    connection1.onopen = function (event) {  };//握手完成，readyState从CONNECTING变成OPEN时触发
    connection1.onclose = function (event) { //readyState从CLOSING变成CLOSED时触发
        //该事件3个有用的属性：wasClean、code、reason，可以使用这些属性向用户报告一些非正常关闭的信息
        if(!event.wasClean){
            console.log(event.code + ':' + event.reason);
        }
    };
    connection1.onerror = function (event) {
        //该事件中包含一个data属性，它包含的是错误对象，通常是一个字符串。
    };
    connection1.onmessage = function (event) {
        //该事件也包含了一个data属性。
        //如果消息是一个文本消息，该属性就是一个字符串
        //如果消息是一个二进制消息，它就是一个Blob数据并且WebSocket的binaryType属性将被设置为blob（默认）
        //如果消息是一个二进制消息，并且binaryType被设置为arraybuffer，那么该属性的值将是一个ArrayBuffer
    };

    /**
     * websocket对象的方法
     */
    //两个方法：send()和close()
    //方法close：接受一个可选的关闭代码作为它的第一个参数（默认为1000），一个可选的字符串reason作为它的第二个参数（默认为空）
    connection1.close();
    //方法send：接受一个字符串、Blob、ArrayBuffer或者ArrayBufferView作为它的唯一参数，它是唯一可以使用bufferdAmount属性的地方
    connection1.send('');
    //示例：不存在等待数据时发送数据到服务器，每隔100毫秒刷新一次数据，如果缓存中仍有数据等待发送，它将等待下一个100毫秒
    var updatedModelData = [];
    connection1.onopen = function (event) {
        var intervalId = window.setInterval(function () {
            if(connection1.readyState !== WebSocket.OPEN){//如果连接未处于打开状态，它就停止数据发送并清除间隔调用
                window.clearInterval(intervalId);
            }
            if(connection1.bufferedAmount === 0){
                connection1.send(updatedModelData);
            }
        },100);
    }
</script>