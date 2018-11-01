$(function () {
    //alert(IEVersion());
});

function test() {
    var param = '重庆大雾';
    var encodeParam = encodeURI(param);
    var decodeParam = decodeURI(encodeParam);
    var h = 0;
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
