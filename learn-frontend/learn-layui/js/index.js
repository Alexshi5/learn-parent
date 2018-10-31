$(function () {
    //alert(IEVersion());
});

function test() {
    var test = '"{"replyContent":"测试接警 201810290008\n' +
        '测试接警 201810290008\n' +
        '测试接警 201810290008\n' +
        '测试接警 201810290008\n' +
        '测试接警 201810290008","optcode":"EVENT_ALARM_IGNOREORTOEVENT","woCode":"U001227469","opcode":"REPORT_EVENT","telOid":"468377","userids":"515,谭显,744,E09.645.001.006.004,高一支六大队勤务四中队"}"\n';
    var test1 = '"{"replyContent":"测试接警 201810290008","optcode":"EVENT_ALARM_IGNOREORTOEVENT","woCode":"U001227469","opcode":"REPORT_EVENT","telOid":"468377","userids":"515,谭显,744,E09.645.001.006.004,高一支六大队勤务四中队"}"\n';
    test = test.replace(/[\n\r]/g,'');
    //test = JSON.parse(test);
    var t = test;
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
