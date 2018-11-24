<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导出word文件</title>
    <script src="/js/jquery-1.8.3.min.js"></script>
    <script src="/js/echarts.js"></script>
</head>
<body>
<button onclick="getDemoEchartsReport()">导出</button>
<div id="content0" style="width: 800px;height: 500px;"></div>
<div id="content1" style="width: 800px;height: 500px;"></div>
<button onclick="downloadWordReport()">下载</button>
<button onclick="test()">测试</button>
</body>
</html>
<script>
    var globalVar = {
        myChar:{}
    };
    $(function () {
        //getDemoEchartsReport();
        //getEchartsReport();
    });

    function getDemoEchartsReport() {
        var option = {
            angleAxis: {
                type: 'category',
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
                z: 10
            },
            radiusAxis: {
            },
            polar: {
            },
            series: [{
                type: 'bar',
                data: [1, 2, 3, 4, 3, 5, 1],
                coordinateSystem: 'polar',
                name: 'A',
                stack: 'a'
            }, {
                type: 'bar',
                data: [2, 4, 6, 1, 3, 2, 1],
                coordinateSystem: 'polar',
                name: 'B',
                stack: 'a'
            }, {
                type: 'bar',
                data: [1, 2, 3, 4, 1, 2, 5],
                coordinateSystem: 'polar',
                name: 'C',
                stack: 'a'
            }],
            legend: {
                show: true,
                data: ['A', 'B', 'C']
            }
        };

        var myChart = echarts.init(document.getElementById("content0"));
        myChart.setOption(option);
        //获取Echart图形报表生成的Base64编码格式的数据
        var imgData = myChart.getConnectedDataURL();
        $.post('/demo/word',{'imgData':imgData},function (data) {
            alert(data);
        },'text');
    }
    
    function getEchartsReport() {
        var option0 = {
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [120, 200, 150, 80, 70, 110, 130],
                type: 'bar'
            }]
        };
        var myChart0 = echarts.init(document.getElementById("content0"));
        myChart0.setOption(option0);
        globalVar.myChar.myChart0 = myChart0;

        var option1 = {
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line',
                areaStyle: {}
            }]
        };
        var myChart1 = echarts.init(document.getElementById("content1"));
        myChart1.setOption(option1);
        globalVar.myChar.myChart1 = myChart1;
    }

    function downloadWordReport() {
        var myChart = globalVar.myChar;
        var imageInfo = myChart.getConnectedDataURL();
        // 向后台发起请求保存图片到指定目录.
        $.post('/export/word/generate',JSON.stringify(myChart),function (data) {
            alert(data);
        },'json');
    }

    function test() {
        var map = {

        };
        map.myChart0 = '123';
        map.myChart1 = '456';
        console.log(map);
        $.post('/test/map',{'imgUrls':JSON.stringify(map)},function (data) {
            alert(data);
        },'json');
    }

</script>