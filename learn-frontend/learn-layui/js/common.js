//统一声明或定义全局变量
var globalVar = {
    countDown:{//倒计时功能
        initTime:undefined,//初始化倒计时的时间
        waitTime:undefined,//正在倒计时的时间
        exeFunction:undefined,//倒计时结束后要执行的方法
        exeTime:undefined,//该倒计时过程要执行的次数，默认为1次
        exeCount:undefined,//统计该倒计时过程已经执行的次数
        isTest:undefined//是否开启测试，默认否
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
        //统计该倒计时过程已经执行的次数要增加1次
        var exeCount = ++globalVar.countDown.exeCount;
        var exeTime = globalVar.countDown.exeTime;
        if(exeCount === exeTime){
            return false;
        }
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
 * @param initTime 初始化倒计时的时间（单位：秒），该参数必须
 * @param exeFunction 倒计时结束后要执行的方法，该参数必须
 * @param exeTime 该倒计时过程要执行的次数，默认为1次，该参数不是必须
 * @param isTest 是否开启测试功能（true：开启，false：不开启，默认为false），该参数不是必须
 */
function finalCountDown(initTime,exeFunction,exeTime,isTest) {
    //对全局变量进行初始化
    globalVar.countDown.initTime = initTime;
    globalVar.countDown.waitTime = initTime;
    globalVar.countDown.exeFunction = exeFunction;
    var regex = /^[1-9]+[0-9]*$/;
    if(regex.test(exeTime)){
        globalVar.countDown.exeTime = exeTime;
    }else {
        globalVar.countDown.exeTime = 1;
    }
    globalVar.countDown.exeCount = 0;
    if(isTest || exeTime){
        //创建一个新的节点
        var newDivNode = document.createElement('div');
        //向新的节点中添加html
        newDivNode.innerHTML = '<div style="border: 1px solid red;margin: auto;width: 100px;text-align: center">倒计时：<span id="span_count_down"></span></div>';
        //获取body中的第一个子节点
        var firstChildNode = document.body.firstChild;
        //在得到的第一个节点之前插入新创建的节点
        document.body.insertBefore(newDivNode, firstChildNode);
        globalVar.countDown.isTest = isTest || exeTime;
    }
    countDown();
}


//测试
$(function () {
    //finalCountDown(10,test123,2,true);
});

function test123() {
    alert(123);
}

/**
 * 判断字符串、数组或对象是否为空，不为空返回true
 * @param obj
 * @returns {boolean}
 */
function isNotEmpty(obj) {
    if (obj === undefined || obj === null) {
        return false;
    }

    var type = typeof obj;
    if (type === 'string' && (obj === '' || obj === 'null' || obj === 'undefined' || obj.trim(obj) === '')) {
        return false;
    }

    if (type === 'object' && (obj.length <= 0 || JSON.stringify(obj) === '{}')) {
        return false;
    }

    return true;
}