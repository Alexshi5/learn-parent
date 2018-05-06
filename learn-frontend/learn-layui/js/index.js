layui.config({
    base: 'js/'
}).use(['layer', 'form'], function () {
    layer = layui.layer;
    /*exports('index', {});*/
});

function test2() {
    layer.open({
        title: '从业人员资格信息',
        area: ['1000px', '300px'],
        type: 1,
        content: $('#certCardTr2')
    });
}

$(function () {
    var milliseconds = new Date().getTime();
    alert(milliseconds);
});