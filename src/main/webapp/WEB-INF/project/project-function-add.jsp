<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加功能信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>

	<script>
        $(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/project/getAllProjectByModule",
                type:"post",
                dataType:"json",
                cache:false,
                success:function(result) {
                    $.each(result,function(index,element){
                        var option="<option pid='"+element.pid+"' value='"+element.pname+"'>"+element.pname+"</option>";
                        $("#proname").append(option);
                    });
                }
            });
        });
		function setAnalysisname() {
			var pid=$("#proname option:selected").attr("pid");
			$.ajax({
                url:"${pageContext.request.contextPath}/analysis/getAnalysisById",
                type:"post",
				data:{"id":pid},
				dataType:"json",
				cache:false,
				success:function (result) {
					$("#analysisname").val(result.title);
					$.ajax({
						url:"${pageContext.request.contextPath}/model/getModelByAnalysis",
						type:"post",
						data:{"analysisId":pid},
						dataType:"json",
						cache:false,
						success:function (result) {
							$("#modeleFk option:not(:lt(1))").remove();
						    $.each(result,function (index,element) {
                                var option="<option value='"+element.id+"'>"+element.modname+"</option>";
                                $("#modeleFk").append(option);
                            })
                        }
					});
                }
			});
        }
        function saveFunction(){
            $.ajax({
                url:"${pageContext.request.contextPath}/function/save",
                type:"post",
                data:$("#functionForm").serialize(),
                dataType:"json",
                cache:false,
                success:function(result) {
                    if(result.status==200){
                        theAlert(result.msg,"alert",function(){
                            window.location="${pageContext.request.contextPath}/project/project-function";
                        });
                    }else if(result.status==400){
                        theAlert(result.msg,"alert");
                    }
                }
            });
        }
	</script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/resources/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath}/resources/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加功能信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="functionForm" id="functionForm">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;添加新功能&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proname" name="proname" onchange="setAnalysisname();">
			<option>请选择---</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" id="analysisname" name="analysisname" readonly="readonly" size="50"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择模块：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="modeleFk" name="modeleFk">
			<option>请选择---</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">功能名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="functionname"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level" id="level">
			<option value="高">高</option>
			<option value="中">中</option>
			<option value="低">低</option>
			<option value="暂缓">暂缓</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea name="simpledis" rows=10 cols=130></textarea></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea name="detaileddis" rows=15 cols=130></textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="remark" rows=10 cols=130></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:saveFunction();" class="coolbg">保存</a>
	<a href="${pageContext.request.contextPath}/project/project-function" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>