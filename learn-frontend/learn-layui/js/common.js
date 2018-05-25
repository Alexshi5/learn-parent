//统一声明或定义全局变量
var globalVar = {
    countDown:{//倒计时功能
        initTime:undefined,//初始化时间常量
        waitTime:undefined,//倒计时时间
        exeFunction:undefined,//倒计时结束后要执行的方法
        isTest:undefined//是否开启测试
    }
    //其他功能
};

/**
 * 倒计时基础方法
 */
function countDown() {
    var waitTime = globalVar.countDown.waitTime;
    //如果是测试，可以在页面添加一个倒计时标签来进行查看
    if (globalVar.countDown.isTest) {
        document.getElementById('span_count_down').innerText = waitTime;
    }

    if (waitTime === 0) {
        //倒计时结束要执行的方法
        globalVar.countDown.exeFunction();
        //重新初始化倒计时时间
        globalVar.countDown.waitTime = globalVar.countDown.initTime;
        countDown();
    } else {
        //倒计时时间递减
        globalVar.countDown.waitTime--;
        //一秒钟调用一次此方法
        setTimeout(countDown, 1000);
    }
}

/**
 * 封装的倒计时通用方法
 * @param initTime 初始化时间（单位：秒）
 * @param exeFunction 倒计时结束后要执行的方法
 * @param isTest 是否开启测试功能（true：开启，false：不开启）
 */
function finalCountDown(initTime,exeFunction,isTest) {
    //创建一个新的节点
    var newDivNode = document.createElement('div');
    //向新的节点中添加html
    newDivNode.innerHTML = '<div style="border: 1px solid red;margin: auto;width: 100px;text-align: center">倒计时：<span id="span_count_down"></span></div>';
    //获取body中的第一个子节点
    var firstChildNode = document.body.firstChild;
    //在得到的第一个节点之前插入新创建的节点
    document.body.insertBefore(newDivNode, firstChildNode);
    globalVar.countDown.initTime = initTime;
    globalVar.countDown.waitTime = initTime;
    globalVar.countDown.exeFunction = exeFunction;
    globalVar.countDown.isTest = isTest;
    countDown();
}


//测试
$(function () {
    finalCountDown(30,test123,true);
});

function test123() {
    alert(123);
}