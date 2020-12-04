<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>对标管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/eacharjs/echarts.common.min.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/resources/skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath}/resources/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:对标管理>>对标分析
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<div id="box" style="width:800px;height:600px;"></div>



<script>
    var myChart = echarts.init(document.getElementById('box'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text:'浪潮软件研发营业额',
            subtext: '营业额分析图',
            left: ''
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {
            type:'value',
            axisLabel:{
                formatter:'{value}(亿)'
            }
        },
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };


    //准备存储x轴下标
    var names=[];
    //准备成绩数组
    var scores=[];
    //2、启动ajax，请求数据
    $.ajax({
        type:'post',
        url:'${pageContext.request.contextPath}/duibiao/showPng',
        dataType:'json',
        success:function(data){
            //判断返回值是否存在
            if(data){
                //json，遍历
                for(var i=0;i<data.length;i++){
                    var date = new Date(data[i].datime);
                    names.push(date.getFullYear()+"年");
                    scores.push(data[i].daturnover);
                }
            }
            option.xAxis.data=names;
            option.series[0].data=scores;
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });



</script>
</body>
</html>