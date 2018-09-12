//统一声明或定义全局变量
var globalVar = {
    
};


//测试
$(function () {

});

/**
 * 调用图片放大功能的方法以及配置项（仅支持jquery-1.11.3.js）
 */
function imageZoomTest() {
    (function($){
        //图片放大功能的配置项
        var defaults = {
            cursorcolor:'255,255,255',
            opacity:0.5,
            cursor:'crosshair',
            zindex:2147483647,
            zoomviewsize:[500,400],//放大之后展示的div宽高
            zoomviewposition:'left',
            zoomviewmargin:300,//距离原图的距离，
            zoomviewborder:'none',
            magnification:4.925//放大的倍数
        };

        imageZoom(defaults);

    })(jQuery);
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
    if (type === 'string' && (obj === '' || obj === 'null' || obj === 'undefined' || obj.trim() === '')) {
        return false;
    }

    if (type === 'object' && (obj.length <= 0 || JSON.stringify(obj) === '{}')) {
        return false;
    }

    return true;
}

/**
 * 判断是否是IE浏览器，如果不是返回-1
 * @returns {*}
 * @constructor
 */
function IEVersion() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
    var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
    var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
    if(isIE) {
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        if(fIEVersion == 7) {
            return 7;
        } else if(fIEVersion == 8) {
            return 8;
        } else if(fIEVersion == 9) {
            return 9;
        } else if(fIEVersion == 10) {
            return 10;
        } else {
            return 6;//IE版本<=7
        }
    } else if(isEdge) {
        return 'edge';//edge
    } else if(isIE11) {
        return 11; //IE11
    }else{
        return -1;//不是ie浏览器
    }
}