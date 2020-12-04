<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加附件</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery.form.js"></script>
<script type="application/javascript">

    function commit(){

        $("#archivesForm").ajaxForm();
        $("#archivesForm").ajaxSubmit(function(data){
            if(data.status==200) {
                alert(data.message);
                window.location="${pageContext.request.contextPath}/office/archives";
            }else{
                alert(data.message);
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
    当前位置:档案管理>>添加档案
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="archivesForm"  action="${pageContext.request.contextPath}/archives/archives/importData" method="post"  ENCTYPE="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
        <input type="file" name="files"/></td>
</tr>
<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">导入员工数据</a>
	<a href="${pageContext.request.contextPath}/project/project-file" class="coolbg">返回</a>
</td>
</tr>
</table>
</form>
  

</body>
</html>