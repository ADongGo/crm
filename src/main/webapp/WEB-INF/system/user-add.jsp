<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
	<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/skin/js/jquery.form.js"></script>
	<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
	<link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />

	<link href="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.css" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/demos.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
	<!--中文-->
	<script src="${pageContext.request.contextPath}/resources/datejs/js/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/resources/datejs/js/jquery-ui-timepicker-zh-CN.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
	<script type="application/javascript">
          $(function(){
              //找所有的职位
              $.ajax({
                  type:'GET',
                  url:'${pageContext.request.contextPath}/emp/getPosition',
                  dataType:'json',
                  success:function(resultData){
                      $(resultData).each(function(index,item){
                          var option="<option value="+item.id+">"+item.name+"</oiption>";
                          $("#position").append(option);
                      });
                  },
              });
              //获取所有的级别
              $.ajax({
                  type:'GET',
                  url:'${pageContext.request.contextPath}/emp/getLevel',
                  dataType:'json',
                  success:function(resultData){
                      $(resultData).each(function(index,item){
                          var option="<option value="+item.jid+">"+item.jname+"</oiption>";
                          $("#level").append(option);
                      });
                  },
              });
              //查询所有的产部门
              $.ajax({
                  type:'GET',
                  url:'${pageContext.request.contextPath}/emp/getDept',
                  dataType:'json',
                  success:function(resultData){
                      $(resultData).each(function(index,item){
                          var option="<option value="+item.deptno+">"+item.dname+"</oiption>";
                          $("#dept").append(option);
                      });
                  }
              });

              //查询所有的角色
              $.ajax({
                  type:'GET',
                  url:'${pageContext.request.contextPath}/role/getAllRoleByStatus',
				  data:{"status":1},
                  dataType:'json',
                  success:function(resultData){
                      $(resultData).each(function(index,item){
                          var option="<option value="+item.roleid+">"+item.rolename+"</oiption>";
                          $("#role").append(option);
                      });
                  }
              });


		  });

          function commit(){

              $("#form19").ajaxForm();
              $("#form19").ajaxSubmit(function(data){
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
    当前位置:权限管理>>添加用户信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" action="${pageContext.request.contextPath}/emp/addEmp" method="post" id="form19" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;添加用户&nbsp;</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="ename"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="esex">
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="eage"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="telephone"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="hiredate" id="time" onfocus="WdatePicker({el:'time'})" readonly="readonly"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="pnum"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">用户名：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="username"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">密码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="password"/></td>
</tr>
<tr>
	<td align="right" bgcolor="#FAFAF1" height="22">头像：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="file" name="personPic"/></td>
</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
		<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<select name="pFk" id="position">
				<option value=1>选择职位</option>
			</select>
		</td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
		<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<select name="lFk" id="level">
				<option value=1>选择级别</option>
			</select>
		</td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">部门：</td>
		<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<select name="dFk" id="dept">
				<option value=1>选择部门</option>
			</select>
		</td>
	</tr>

	<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="roleFk" id="role">
			<option value=-1>选择角色</option>
		</select>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark"></textarea>
	</td>
</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
	<a href="user.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>