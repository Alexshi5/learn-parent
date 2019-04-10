//公共变量:用于是否跨域设置 0:直接访问 1:跨域访问
var PageDebug = 1;

//Description:为JS扩展相关方法
//Date:2013-12-9
//Author:zx    
; (function (undefined) { 
    /*确定多选框数据 适合于表格*/
    /*
    *obj:删除对象
    *evt:对应事件
    */
    window.selectMutiCheckBox = function (keyIDName) {
        var idlist = "";
        $("input:checkbox").each(function () {
            if ($(this).prop("checked")) {
                var tr = $(this).parents("tr");
                if ($(this).prop("id") != "selectall") {
                    var id = tr.attr(keyIDName);
                    if (id != "" && id != "undefined") {
                        idlist += id + ",";
                    }
                }
            }
        });
        if (idlist != "") {
            idlist = idlist.substr(0, idlist.length - 1);
        }
        return idlist;
    };

    /*确定多选框数据 适合于CheckBoxSelf*/
    /*
    *obj:删除对象
    *evt:对应事件
    */
    window.selectMutiCheckBoxSelf = function (ctrlName) {
        var idlist = "";
        $("input:checkbox").each(function () {
            if ($(this).prop("checked")) {
                if ($(this).prop("name") == ctrlName) {
                    var id = $(this).val();
                    if (id != "" && id != "undefined") {
                        idlist += id + ",";
                    }
                }
            }
        });
        if (idlist != "") {
            idlist = idlist.substr(0, idlist.length - 1);
        }
        return idlist;
    };
    
    /*本页面无遮罩弹窗*/
    /*
    *url:url地址
    *title:弹窗标题
    *width:弹窗宽度
    *height:弹窗高度
    */
    window.OpenMyWindow = function (url, title, width, height, scroll, endCallBack) {
        var poppage = layer.open({
            type: 2,
            title: [
                title,
                'width: ' + width + ';padding:0px 0px 0px 0px; height: 35px; font-weight: bold; font-size: 14px; line-height: 35px; overflow: hidden; color: #707071; text-align: center; background: #f0f2f5;' //自定义标题样式
            ],
            shadeClose: false,
            shade: 0,
            zIndex: 10,
            closeBtn: 2,
            border: [0],
            //offset: ['20px', ''],
            area: [width, height],
            content: [url, scroll], //iframe的url，no代表不显示滚动条
            success: function (layero, index) {
            },
            end: function () {
                if (endCallBack) {
                    endCallBack();
                }
            }
        });
        return poppage;
    };

    /*本页面弹窗*/
    /*
    *url:url地址
    *title:弹窗标题
    *width:弹窗宽度
    *height:弹窗高度
    */
    window.OpenPopWindow = function (url, title, width, height, scroll, endCallBack) {
        var poppage = layer.open({
            type: 2,
            title: [
                title,
                'width: ' + width + ';padding:0px 0px 0px 0px; height: 35px; font-weight: bold; font-size: 14px; line-height: 35px; overflow: hidden; color: #707071; text-align: center; background: #f0f2f5;' //自定义标题样式
            ],
            shadeClose: false,
            shade: 0.5,
            zIndex: 10,
            closeBtn: 1,
            border: [0],
            //offset: ['20px', ''],
            area: [width, height],
            content: [url, scroll], //iframe的url，no代表不显示滚动条
            success: function (layero, index) {
            },
            end: function () {
                if (endCallBack) {
                    endCallBack();
                }
            }
        });
        return poppage;
    };

    /*顶部页面弹窗*/
    /*
    *url:url地址
    *title:弹窗标题
    *width:弹窗宽度
    *height:弹窗高度
    */
    window.OpenPopWindowTop = function (url, title, width, height, scroll, endCallBack) {
        var loadingIndex = top.layer.load(2);
        var poppage = top.layer.open({
            type: 2,
            title: [
                title,
               // 'width: ' + width + ';padding:0px 0px 0px 0px; height: 35px; font-weight: bold; font-size: 14px; line-height: 35px; overflow: hidden; color: #707071; text-align: center; background: #f0f2f5;' //自定义标题样式
            ],
            shadeClose: false,
            scrollbar: true,
            anim:5,
            shade: 0.5,
            zIndex: 10,
            closeBtn: 1,
            border: [0],
            //offset: ['20px', ''],
            area: [width, height],
            content: [url, scroll], //iframe的url，no代表不显示滚动条
            success: function (layero, index) {
                top.layer.close(loadingIndex);
            },
            end: function () {
                if (endCallBack) {
                    endCallBack();
                }
            }
        });
        return poppage;
    };

    /*本页面弹出提示信息*/
    /*
    *msg:提示内容
    */
    window.ShowPopAlert = function (msg) {
        //top.layer.alert(msg);
        layer.alert(msg);
    };

    /*本页面弹出提示信息*/
    /*
    *msg:提示内容
    *iconID:图标ID
    */
    window.ShowPopAlert = function (msg, iconID) {
        //top.layer.alert(msg, { icon: iconID });
        layer.alert(msg, { icon: iconID });
    };

    /*loading页面*/
    /*
    */
    window.ShowLoading = function () {
        $(".top_button").attr("disabled", true);
        if ($("body").find(".loadImg").length == 0) {
            $("body").append('<div class=\"loading\"><img src="/res/image/login/loading.gif"></div>');
        }
        $(".loading").show();
    };
    /*loading页面*/
    /*
    */
    window.CloseLoading = function () {
        if ($("body").find(".loading").length > 0) {
            $(".loading").hide();
            $(".top_button").attr("disabled", false);
        }
    };
    /*获取querystring*/
    /*
    */
    window.getQueryString = function () {
        var locSearch = location.search;
        if (locSearch != "");
        {
            locSearch = locSearch.substring(1);
        }
        return locSearch;
    };

    window.openWindow = function (url, uName, width, height, scroll) {        
        var stylecss = "toolbar=no,location=no,status=no,menubar=no,scrollbars=" + scroll + ",resizable=no,width=" + width + ",height=" + height + ",top=" + (screen.availHeight - height) / 2 + ",left=" + (screen.availWidth - width) / 2;
        var wopen = window.open(url, uName, stylecss);
        wopen.focus();
    };

    window.openPrintWindow = function (url) {
        var destUrl = "/Public/PrintDoc?url=" + encodeURIComponent(url);
        var winWidth = screen.availWidth - 100;
        var winHeight = screen.availHeight - 100;
        var stylecss = "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=" + winWidth + ",height=" + winHeight + ",top=" + (screen.availHeight - winHeight) / 2 + ",left=" + (screen.availWidth - winWidth) / 2;
        var wopen = window.open(destUrl, "printWindow", stylecss);
        wopen.focus();
    };
})(window);

