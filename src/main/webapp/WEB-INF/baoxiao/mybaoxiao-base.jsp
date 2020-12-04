<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>附件管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/resources/skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath}/resources/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:个人报销管理>>报销列表
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/baoxiao/mybaoxiao-add';" value='添加报销' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>


<!--  内容列表   -->
<form name="form2">

<table width="98%"  cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="30%">编号</td>
	<td width="6%">总金额</td>
	<td width="10%">使用时间</td>
	<td width="30%">备注信息</td>
	<td width="10%">审批状态</td>
	<td width="10%">操作</td>
</tr>
<c:forEach var="baoxiao" items="${baoxiaos}">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>${baoxiao.bxid}</td>
	<td>${baoxiao.totalmoney}</td>
	<td align="center"><u><fmt:formatDate value="${baoxiao.bxtime}" pattern="yyyy-MM-dd" /></u></td>
	<td>${baoxiao.bxremark}</td>
   <td>
	   <c:if test="${baoxiao.bxstatus==1}"><span style="color:blue">未审批</span></c:if>
	   <c:if test="${baoxiao.bxstatus==2}"><span style="color:red">驳回</span></c:if>
	   <c:if test="${baoxiao.bxstatus==3}"><span style="color:green">已审批</span></c:if>
   </td>
   <td>
	   <c:if test="${baoxiao.bxstatus==1 || baoxiao.bxstatus==2}"><a href="${pageContext.request.contextPath}/baoxiao/getBaoXiaoByBxid/${baoxiao.bxid}/mybaoxiao-edit">编辑</a></c:if>
	   <c:if test="${baoxiao.bxstatus==3}"><a href="">查看详情</a></c:if>
   </td>
</tr>
</c:forEach>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>