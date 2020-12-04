<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加附件</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery.form.js"></script>

	<script>
		$(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/project/getAllProject",
				type:"post",
				dataType:"json",
				cache:false,
				success:function (result) {
					$.each(result,function (index,element) {
						var option="<option value='"+element.pid+"'>"+element.pname+"</option>";
						$("#proFk").append(option);
                    });
                }
			});
        });

        function saveFile() {
			$("#Attachform").ajaxForm();
			$("#Attachform").ajaxSubmit(function (result) {
                if(result.status==200){
                    theAlert(result.msg,"alert",function(){
                        window.location="${pageContext.request.contextPath}/attachment/queryAttachments";
                    });
                }else if(result.status==400){
                    theAlert(result.msg,"alert");
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
    当前位置:项目管理>>添加附件
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="Attachform" id="Attachform" action="${pageContext.request.contextPath}/attachment/save" method="post" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;添加附件&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proFk" name="proFk">
			<option>请选择---</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="attname" size="26"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件信息描述：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="attdis" size="52"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="attachmentFile" type="file"/></td>
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
	<a href="javascript:saveFile();" class="coolbg">保存</a>
	<a href="${pageContext.request.contextPath}/attachment/queryAttachments" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>