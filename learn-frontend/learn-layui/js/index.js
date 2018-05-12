layui.config({
    base: 'js/'
}).use(['layer', 'form'], function () {
    layer = layui.layer;
    /*exports('index', {});*/
});

function test2() {
    /*layer.open({
        title: '从业人员资格信息',
        area: ['1000px', '300px'],
        type: 1,
        content: $('#certCardTr2')
    });*/
    //var regex = /^(1[0-9]{2,2})?(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})?((\\-[0-9]{1,4})?|1\\d{10})$/;
    var regex = /(^(0[0-9]{2,3}(\-)?)?([1-9][0-9]{4,7})$)|(^((\+)?[1-9]{2,3})?(1[0-9]{10})$)|(^1[0-9]{2}$)/;
    //var regex =/^(1[0-9]{10})$/;
    var p = $('#phone').val();
    var b = regex.test(p);
    alert(b);
}

$(function () {
    /*var milliseconds = new Date().getTime();
    alert(milliseconds);*/
});