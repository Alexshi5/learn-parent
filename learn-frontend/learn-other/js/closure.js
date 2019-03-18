$(function () {
    /*var d = new a1();
    d.b();*/

    var c = new a2();
    c.b();
    c.b();
});

//闭包：有权访问另一个函数作用域内变量的函数叫做闭包，只用内部函数才能访问外部函数的局部变量，通过闭包来当作内部函数与外部函数的桥梁

/**
 * 闭包一
 */
function a1() {
    var i = 0;

    function b() {
        i++;
        alert(i);
    }

    b();
    b();
}

/**
 * 闭包二
 */
function a2() {
    var i = 0;
    this.b = function () {
        i++;
        alert(i);
    }
}