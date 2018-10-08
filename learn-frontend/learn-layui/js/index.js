$(function () {
    //alert(IEVersion());
});

function test() {

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
