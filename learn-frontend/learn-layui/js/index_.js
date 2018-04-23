/*
window.onload=function () {
    var buttonNode=document.getElementById('button');
    alert(buttonNode);
    var buttoValue=buttonNode.value;
    alert(buttoValue);
    var a;
    alert(!a);
}*/

$(function () {
    /* var a = 0;
     var b = (0 == a || 1 == a) ? 'yes' : 'no';
     alert(b);*/

    /* var val = '小明;';
     var result = val.split(';');
     alert(result.length + '==' + result[0]);*/
    /*
        var i = 10;
        if (i > 5) {
            i = i + 3;
        }
        alert(i);*/


    /* if (true) {
         alert(true);
     }
     if (false) {
         alert(false)
     }*/

    /*var t = new test();
    var f = t.testj();
    alert(f);*/

    for (var i = 0; i < 3; i++) {
        var num = new test();
        alert(num.number());
    }
});

/*
function test() {
    var i = 10;

    this.testj = function () {
        return i;
    }
}*/

function test() {
    var num = 3;
    this.number = function () {
        return num;
    }
}
