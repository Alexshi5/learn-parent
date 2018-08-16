$(function () {
   var code1 = 'E09.645.001.001';
   var code2 = 'E09.645.001.001';
   alert(code2.indexOf(code1)!=-1);
});



/**
 * 失去焦点的时候判断是否输入内容，如果没有输入就输入提示信息
 * @param obj
 */
function updateText(obj) {
    var tipHtml = '<div onblur="updateText(this)" onfocus="clearText(this)" contenteditable="true" contenteditable="plaintext-only" style="border:1px solid red;width: 100%;height: 100%"><span class="tipInfo" style="color: lightgray">请输入</span></div>';
    //var tipHtml = '';
    var tdText = $(obj).text();
    if(!isNotEmpty(tdText)){//如果为空，没有填入任何信息
        $(obj).parent().html(tipHtml);
    }
}

/**
 * 获取焦点的时候清除提示信息
 * @param obj
 */
function clearText(obj) {
    var tipInfo = $(obj).find('.tipInfo');
    if(isNotEmpty(tipInfo)){//如果有提示信息
        tipInfo.remove();
    }
}

function test1(param,param1) {
    alert(param+'=='+param1);
}