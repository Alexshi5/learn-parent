$(function () {
    var list = [10,25,20];
    list.sort(sequenceTop);
    var l = list;
});


function sequenceTop(a, b) {
    return b - a;
}