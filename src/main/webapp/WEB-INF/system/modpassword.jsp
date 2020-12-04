<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css">
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
	<script>
		function commit() {
			$.ajax({
				url:'${pageContext.request.contextPath}/emp/updatePassword',
				type:"post",
				data:$("#form2").serialize(),
				dataType:"json",
				cache:false,
				success:function (result) {
					if(result.status==200){
					    theAlert(result.message,"alert");
					    window.location="${pageContext.request.contextPath}/main/index";
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
    当前位置:我的信息>>修改密码
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;修改密码&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">原密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="oldPassword"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">新密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="newPassword"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">确认密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="conPassword"/></td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit();" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>