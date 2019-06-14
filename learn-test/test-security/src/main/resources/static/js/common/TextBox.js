$(function ()
{
    $('input:text:first').focus();
    var $inp = $('input:text');
    $inp.bind('keydown', function (e)
    {
        var key = e.which;
        if (key == 13 || key == 40)//回车 向下
        {
            e.preventDefault();
            var nxtIdx = $inp.index(this) + 1;
            $("input:text:eq(" + nxtIdx + ")").focus();
        }
        else if (key == 38)//向上
        {
            e.preventDefault();
            var nxtIdx = $inp.index(this) - 1;
            $("input:text:eq(" + nxtIdx + ")").focus();
        }
    });
    $inp.bind('focus', function (e) {
        $(this).select();
    });
});

function initTextBox() {
    $('input:text:first').focus();
    var $inp = $('input:text');
    $inp.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13 || key == 40)//回车 向下
        {
            e.preventDefault();
            var nxtIdx = $inp.index(this) + 1;
            $("input:text:eq(" + nxtIdx + ")").focus();
        }
        else if (key == 38)//向上
        {
            e.preventDefault();
            var nxtIdx = $inp.index(this) - 1;
            $("input:text:eq(" + nxtIdx + ")").focus();
        }
    });
    $inp.bind('focus', function (e) {
        $(this).select();
    });
}
