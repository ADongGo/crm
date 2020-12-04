<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
	<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
	<script type="text/javascript">
		   $(function(){
               $.ajax({
                   type: 'GET',
                   url: '${pageContext.request.contextPath}/role/getAllRole',
                   dataType: 'json',
                   success: function (rs) {
                        $(rs).each(function(index,item){
                            var newstatus = "禁用";
                            if(item.status==1){
                                newstatus = "启用";
							}
                            var tr = "<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                                "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                                "\t<td>"+item.roleid+"</td>\n" +
                                "\t<td>"+item.rolename+"</td>\n" +
                                "\t<td align=\"center\">"+item.roledis+"</td>\n" +
                                "\t<td>"+newstatus+"</td>\n" +
                                "\t<td><a href='javascript:deleteInfo("+item.roleid+")'>删除</a> |<a href='${pageContext.request.contextPath}/role/role-edit?roleid="+item.roleid+"'>编辑</a> | <a href=\"role-look.jsp\">查看详情</a></td>\n" +
                                "</tr>";
                            $("#ttr").after(tr);

						});
                   }
			   });
		   });

		   function  deleteInfo(obj){
		        theAlert("确认删除当前角色么?","confirm",function(r){
		             if(r){
                         $.ajax({
                             type:"get",
                             url:"${pageContext.request.contextPath}/role/deleteRoleById?roleid="+obj,
                             dataType:"json",
                             cache:false,
                             success:function(data){
                                 if(data.status==200){

									 alert(data.message);
                                     window.location="${pageContext.request.contextPath}/role/role";

                                 }else {
                                     theAlert(data.message,"alert");
                                 }
                             }
                         });
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
    当前位置:权限管理>>角色管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/role/role-add';" value='添加角色' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>


<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;角色列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" id="ttr">
	<td width="4%">选择</td>
	<td width="6%">编号</td>
    <td width="10%">角色名称</td>
	<td width="10%">角色描述</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>

<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>1</td>
	<td>普通员工</td>
	<td align="center">具有日常的普通功能</td>
	<td>启用</td>
	<td><a >删除</a> |<a href="role-edit.jsp">编辑</a> | <a href="role-look.jsp">查看详情</a></td>
</tr>--%>


<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;禁用&nbsp;</a>
	<a href="" class="coolbg">&nbsp;启用&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>