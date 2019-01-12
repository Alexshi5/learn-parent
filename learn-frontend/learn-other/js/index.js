$(function () {

});

/**
 * 测试正则表达式
 */
function test() {
    var regex = /^ZHZX[0-9]{8,14}$/;
    var val = $('#test').val();
    alert(regex.test(val));

    var str = val.substring(4,10);
    alert(str);
}