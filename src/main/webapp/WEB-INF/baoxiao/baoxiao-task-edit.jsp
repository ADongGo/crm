<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑附件</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script>
	function commit(bxstatus) {
		if(bxstatus==3){
		    var pizhu=$("#pizhu").val();
		    if(pizhu==null || pizhu==""){
		        $("#pizhu").val("同意");
			}
		}
		if(bxstatus==2){
            var pizhu=$("#pizhu").val();
            if(pizhu==null || pizhu==""){
                alert("必须写驳回的原因");
                return;
			}
		}
		$("#bxstatus").val(bxstatus);
		$("#formBaoxiao").submit();
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
    当前位置:项目管理>>报销审批
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="formBaoxiao" method="post" action="${pageContext.request.contextPath}/baoxiao/approveBaoxiao">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr >
	<td colspan="2"  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input  type="hidden" name="bxid" id="bxid" value="${baoxiao.bxid}"/>
		<input type="hidden" name="bxstatus" id="bxstatus"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">金额：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="totalmoney" value="${baoxiao.totalmoney}" readonly="true"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">使用时间</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

		<input name="bxtime" value="<fmt:formatDate value="${baoxiao.bxtime}" pattern="yyyy-MM-dd"/>" readonly="true"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="bxremark"  rows=10 cols=130 readonly="true">${baoxiao.bxremark}</textarea>
	</td>
</tr>
	<tr >
	<td align="right" bgcolor="#FAFAF1" >批准信息：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<!-- 批注信息 -->
		<textarea rows=10 id="pizhu" cols=130 name="result" placeholder=""></textarea>
	</td>
</tr >

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit(3)" class="coolbg">同意</a>
	<a href="javascript:commit(2)" class="coolbg">驳回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>