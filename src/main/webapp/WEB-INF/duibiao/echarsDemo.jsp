<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <script src='${pageContext.request.contextPath}/resources/eacharjs/echarts.common.min.js'></script>

    <script type="text/javascript">
        $(function(){
            //准备存储x轴下标
            var names = [];
            //准备成绩数组
            var scores = [];
            //基于准备好的DOM，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            //ajax获取异步数据
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/duibiao/showPng',
                dataType: 'json',
                success: function (response) {
                    //判断返回值是否存在
                    if (response) {
                        //json，遍历
                        for (var i = 0; i < response.length; i++) {
                            var date = new Date(response[i].datime);
                            names.push(date.getFullYear() + "年");
                            scores.push(response[i].daturnover);
                        }
                        //指定图表的配置项和数据
                        var option = {
                            title: {
                                text: 'EChars入门'
                            },
                            //提示框组件
                            tooltip: {
                                //坐标轴触发，主要用于柱状图，折线图等
                                //trigger: 'axis'
                            },
                            //图例
                            legend: {
                                data: ['销量']
                            },
                            //横轴
                            xAxis: {
                                //data:["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                                data: names
                            },
                            //纵轴
                            yAxis: {},
                            //系列列表。每个系列通过type决定自己的图表类型
                            series: [{
                                name: '销量',
                                //折线图
                                type: 'line',
                                //data:[5, 20, 36, 10, 10, 20]
                                data: scores
                            }]
                        };
                        //使用刚指定的配置项和数据显示图表
                        myChart.setOption(option);
                    }
                }
            });
        });



    </script>
</head>
<body>
<div id='main' style='width:600px;height:400px;'></div>
</body>
</html>
