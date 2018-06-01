layui.config({
    base: 'js/'
}).use(['layer', 'form'], function () {
    layer = layui.layer;
    /*exports('index', {});*/
});

var globalVar = {
   a:10,
    b:5
};

function test2() {

    var testVal = $('#phone').val();
    var regex = /^[1-9]+[0-9]*$/;
    alert(regex.test(testVal));

    //alert(globalVar.a*5);

    //globalVar.var2();
    //var result =
    //alert(result);

    /*tip1 = layer.confirm('确定要打开此层页面吗？', {
            btn: ['确定', '取消']
        }, function () {
            layer.close(tip1);
            layer.open({
                title: '从业人员资格信息',
                area: ['1000px', '300px'],
                type: 1,
                content: $('#certCardTr2') ,//'<div id="certCardTr2"></div>'
                success: function () {
                    var id = $('#certCardTr2').attr('id');
                    $('#certCardTr2').text('123')
                },
                yes:function () {
                    $('#certCardTr2').text('789')
                }
            });
        }, function () {

        }
    );*/
    /* layer.open({
         title: '从业人员资格信息',
         area: ['1000px', '300px'],
         type: 1,
         content: $('#certCardTr2'),
         success :function () {
             var id=$('#certCardTr2').attr('id');
             alert(id);
         }
     });*/


    /*//var regex = /^(1[0-9]{2,2})?(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})?((\\-[0-9]{1,4})?|1\\d{10})$/;
    var regex = /(^(0[0-9]{2,3}(\-)?)?([1-9][0-9]{4,7})$)|(^((\+)?[1-9]{2,3})?(1[0-9]{10})$)|(^1[0-9]{2}$)/;
    //var regex =/^(1[0-9]{10})$/;
    var p = $('#phone').val();
    var b = regex.test(p);
    alert(b);*/

    /*var obj = $('#test');
    alert(isNotEmpty(obj));*/


}

$(function () {
    /*var milliseconds = new Date().getTime();

    alert(milliseconds);*/

    /*alert(globalVar.a);
    globalVar.a = 5;
    alert(globalVar.a);*/

    var var1 = true;
    var var2 = undefined;
    var var3;
    if(var1 || var2){
        var3 = var1 || var2;
    }
    alert(var3);

});

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


