<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加附件</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>


	<script>
           function commit(bxstatus){
               $("#bxstatus").val(bxstatus);
               $("#baoxiaoForm").submit();
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
    当前位置:报销管理>>更新报销
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="baoxiaoForm" action="${pageContext.request.contextPath}/baoxiao/updateBaoxiaoByBxid" method="post">
     <input type="hidden" value="${baoxiao.bxid}" id="bxid" name="bxid">
	<input type="hidden" id="bxstatus" name="bxstatus">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;添加新的报销单&nbsp;</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">支出类型：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

		<select name="paymode" id="paymode">
            <c:if test="${baoxiao.paymode eq '出差票据'}">
				<option value="出差票据" selected>出差票据</option>
				<option value="办公采购">办公采购</option>
				<option value="其他">其他</option>
			</c:if>
			<c:if test="${baoxiao.paymode eq '办公采购'}">
				<option value="出差票据">出差票据</option>
				<option value="办公采购" selected>办公采购</option>
				<option value="其他">其他</option>
			</c:if>
			<c:if test="${baoxiao.paymode eq '其他'}">
				<option value="出差票据" >出差票据</option>
				<option value="办公采购">办公采购</option>
				<option value="其他" selected>其他</option>
			</c:if>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">总金额：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="26"  id="totalmoney" name="totalmoney" value="${baoxiao.totalmoney}"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">使用时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="52" name="bxtime" id="bxtime" readonly="readonly" value='<fmt:formatDate value="${baoxiao.bxtime}" pattern="yyyy-MM-dd"/>'/>

	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130  id="bxremark" name="bxremark">${baoxiao.bxremark}</textarea>
	</td>
</tr>
    <tr >
		<td align="right" bgcolor="#FAFAF1" >批注：</td>
		<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
			<span> 王翠花于<fmt:formatDate value="${baoxiao.shenpidate}" pattern="yyyy-MM-dd"/>审批：驳回  原因：${baoxiao.result}<span>
		</td>
	</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit(1)" class="coolbg">更新</a>
	<a href="project-file.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>

</body>
</html>