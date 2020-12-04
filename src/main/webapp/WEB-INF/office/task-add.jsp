<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
	<script>
		$(function () {
			$.ajax({
                url:"${pageContext.request.contextPath}/project/getProjectByFunctionAndEid",
                type:"post",
                dataType:"json",
                cache:false,
                success:function(result) {
                    $.each(result,function(index,element){
                        var option="<option value='"+element.pid+"'>"+element.pname+"</option>";
                        $("#proname").append(option);
                    });
                }
			});
            //查询执行者
            $.ajax({
                url:"${pageContext.request.contextPath}/emp/getEmployeeByLikePositionName",
                type:"post",
                data:{"positionName":"开发工程师"},
                dataType:"json",
                cache:false,
                success:function(result) {
                    $.each(result,function(index,element){
                        var option="<option value='"+element.eid+"'>"+element.ename+"---"+element.position.name+"</option>";
                        $("#empFk2").append(option);
                    });
                }
            });
        });


        function setAnalysisname() {
            var pid=$("#proname option:selected").attr("value");
            $.ajax({
                url:"${pageContext.request.contextPath}/analysis/getAnalysisById",
                type:"post",
                data:{"id":pid},
                dataType:"json",
                cache:false,
                success:function(result) {
                    $("#analysisname").val(result.title);
                    $.ajax({
                        url:"${pageContext.request.contextPath}/model/getModelByAnalysis",
                        type:"post",
                        data:{"analysisId":pid},
                        dataType:"json",
                        cache:false,
                        success:function(result) {
                            $("#modeleFk option:not(:lt(1))").remove();
                            $.each(result,function(index,element){
                                var option="<option value='"+element.id+"'>"+element.modname+"</option>";
                                $("#modeleFk").append(option);
                            });
                        }
                    });
                }
            });
        }
        
        function setFunction() {
			var moduleId=$("#modeleFk option:selected").val();
            $.ajax({
				url:"${pageContext.request.contextPath}/function/getFunctionsByNoTask",
				type:"post",
				data:{"moduleId":moduleId},
				dataType:"json",
				cache:false,
				success:function (result) {
				    alert(result.length);
				    if(result.length==0){
				        $("#btn")[0].disable=true;
					}else{
				        $("#btn")[0].disable=false;
					}
				    $("#funFk option:not(:lt(1))").remove();
					$.each(result,function (index,element) {
						var option="<option value='"+element.id+"'>"+element.functionname+"<option>";
                        $("#funFk").append(option);
                    });
                }
			});
        }
        
        function saveTask() {
            $.ajax({
                url:"${pageContext.request.contextPath}/office/office/save",
                type:"post",
                data:$("#taskForm").serialize(),
                dataType:"json",
                cache:false,
                success:function(result) {
                    if(result.status==200){
                        theAlert(result.message,"alert",function(){
                            window.location="${pageContext.request.contextPath}/office/office/getTaskByEmployee/office";
                        });
                    }else if(result.status==400){
                        theAlert(result.message,"alert");
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
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="taskForm">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proname" onchange="setAnalysisname();">
			<option>请选择项目---</option>
		</select>-
		<input type="text" id="analysisname" readonly="readonly"/>
		<select id="modeleFk" onchange="setFunction();">
			<option>请选择模块---</option>
		</select>-
		<select id="funFk" name="funFk">
			<option>请选择功能---</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="tasktitle"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="starttime" id="starttime" onfocus="WdatePicker({el:'starttime'})" readonly="readonly"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="endtime" id="endtime" onfocus="WdatePicker({el:'endtime'})" readonly="readonly"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="empFk2" name="empFk2">
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level">
			<option value="高">高</option>
			<option value="中">中</option>
			<option value="低">低</option>
			<option value="暂缓">暂缓</option>
		</select>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<input type="button" value="保存" id="btn" onclick="saveTask();">
</td>
</tr>
</table>

</form>
  

</body>
</html>