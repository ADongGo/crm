<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>编辑用户信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery.form.js"></script>
<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
<script>
    function commit(){

        $("#form20").ajaxForm();
        $("#form20").ajaxSubmit(function(data){
            if(data.status==200){
                theAlert(data.message,"alert",function(){
                    window.location="${pageContext.request.contextPath}/emp/user";
                });
            }else if(data.status==400){
                theAlert(data.message,"alert");
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
    当前位置:权限管理>>编辑用户
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form20" action="${pageContext.request.contextPath}/emp/updateEmployeeById" method="post" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;编辑用户&nbsp;
		 <input type="hidden" name="eid" value="${employee.eid}" />
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="ename" value="${employee.ename}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="esex">
			<c:if test="${employee.esex=='男'}">
				<option value="男" selected>男</option>
				<option value="女">女</option>
			</c:if>
			<c:if test="${employee.esex=='女'}">
				<option value="男">男</option>
				<option value="女"  selected>女</option>
			</c:if>
		</select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input value="${employee.eage}" name="eage"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="telephone" value="${employee.telephone}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="hiredate" value='<fmt:formatDate value="${employee.hiredate}" pattern="yyyy-MM-dd"/>' id="time" onfocus="WdatePicker({el:'time'})" readonly="readonly"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="pnum" value="${employee.pnum}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">用户名：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="username" value="${employee.username}"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">密码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="password" value="" placeholder="修改密码请添写新密码"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">头像：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="file" name="personPic"/>不修改头象，不需要输入！
		<input type="hidden" name="pic" value="${employee.pic}"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="pFk">
			<c:forEach var="position" items="${positionList}">
			<option value="${position.id}"  <c:if test="${employee.pFk==position.id}">selected</c:if>>${position.name}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="lFk" id="level">
			<c:forEach var="level" items="${levelList}">
			      <option value="${level.jid}"  <c:if test="${employee.lFk==level.jid}">selected</c:if>>${level.jname}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">部门：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="dFk" id="dept">
			<c:forEach var="dept" items="${deptList}">
			    <option value="${dept.deptno}" <c:if test="${employee.dFk==dept.deptno}">selected</c:if>>${dept.dname}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="roleFk">
			<option value="" <c:if test="${employee.empRole.erid==null}">selected</c:if>>该用户没有角色，请选择角色！</option>
			<c:forEach var="role" items="${roleList}">
				<option value="${role.roleid}" <c:if test="${role.roleid==employee.empRole.roleFk}">selected</c:if>>${role.rolename}</option>
			</c:forEach>.
		</select>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark">${employee.remark}</textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit();" class="coolbg">更新</a>
	<a href="${pageContext.request.contextPath}/emp/user" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>