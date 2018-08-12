$(function () {
    var domNode = $('.domNode')[0];
    var id = $(domNode).attr('id');
    var val1 = $('#node1').text();
    var val2 = $('#node2').text();
    var val3 = $('#node3').text();
    console.log(val1+'_'+val2+'_'+val3);
    var result1 = isNaN(val1);
    var result2 = isNaN(val2);
    var result3 = isNaN(val3);
    console.log(result1+'_'+result2+'_'+result3);
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