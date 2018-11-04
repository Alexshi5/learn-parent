$(function () {
    //alert(IEVersion());
});

function test() {
    var param = '1,2,3,4';
    var param1 = param.replace(/,/g,'');
    var param3 = param.replace(/[,]/g,'');
    var regexp = new RegExp(',','g');
    var param4 = param.replace(regexp,'');
}

/**
 * 获取json文件中的json数据
 */
function getJson() {
    $.getJSON('json/test.json',function (data) {
        var data1 = data;
        console.log(data);
    });
}
