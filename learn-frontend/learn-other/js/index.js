$(function () {

});


function test() {
    var bayonetCode = '0106-01-015@@@DS-2CD9131-S 0120150806B0CCRR534973952,0106-01-015@@@DS-2CD9131-S(PL) 20160815BB638709230,0106-01-015@@@DS-2CD9131-S(PL) 20161227BB700012293,6673@@@4G50SK000L0089,6673@@@4G50SK000L0090,6673@@@6673';
    var tollcode = '';
    var tollCodeMap = {};
    if(isNotEmpty(bayonetCode)){
        var bayonetCodeArr = bayonetCode.split(',');
        bayonetCode = '';
        for(var i=0;i<bayonetCodeArr.length;i++){
            var tempArr = bayonetCodeArr[i].split('@@@');
            bayonetCode += tempArr[1] + ',';
            tollCodeMap[tempArr[0]] = tempArr[0];
        }
        bayonetCode = bayonetCode.substring(0,bayonetCode.length-1);
        for(var key in tollCodeMap){
            tollcode += key + ',';
        }
        tollcode = tollcode.substring(0,tollcode.length-1);
    }else {
        bayonetCode = '';
    }

    var result1 = tollcode;
    var result2 = bayonetCode;
}

//测试将数组转化为json
function arrToJson() {
    var tempArr = [];
    var obj1 = {name:'小明',age:20};
    var obj2 = {name:'小张',age:25};
    tempArr.push(obj1);
    tempArr.push(obj2);
    var json = JSON.stringify(tempArr);
}

/**
 * 测试正则表达式
 */
function regex() {
    var regex = /^ZHZX[0-9]{8,14}$/;
    var val = $('#test').val();
    alert(regex.test(val));

    var str = val.substring(4,10);
    alert(str);
}

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

    if (type === 'string' && (obj === '' || obj === 'null' || obj === 'undefined' || obj.trim() === '')) {
        return false;
    }

    if (type === 'object' && (obj.length <= 0 || JSON.stringify(obj) === '{}')) {
        return false;
    }

    return true;
}
