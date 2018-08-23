//统一声明或定义全局变量
var globalVar = {
    
};


//测试
$(function () {
    
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