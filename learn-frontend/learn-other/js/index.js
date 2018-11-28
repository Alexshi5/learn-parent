$(function () {

});

/**
 * 测试正则表达式
 */
function testRegex() {
    var regex = /^2[0-9]{3}-(0[1-9]|1[0-2])$/;
    var val = $('#test').val();
    var result = regex.test(val);
    alert(result);
}