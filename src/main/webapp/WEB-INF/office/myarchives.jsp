<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加项目信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    function get_date(source){
        var date=new Date(source);
        var year=date.getFullYear();
        var month=formatDate(date.getMonth()+1);
        var day=formatDate(date.getDate());
        return year+"-"+month+"-"+day;
    }

    function formatDate(value){
        if(value<10)
        {
            return "0"+value;
        }else{
            return value;
        }
    }
        $(function(){
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/emp/person/getEmloyeeArchives',
                dataType:'json',
                success:function(employee){
					var position=employee.position;
                    var archives = employee.archives;
                    var dept = employee.dept;
                    var level = employee.level;
                    $("#eid").val(employee.eid);
                    $("#dnum").val(archives.dnum);
                    $("#ename").val(employee.ename);
                    $("#esex").val(employee.esex);
                    $("#school").val(archives.school);
                    $("#zzmm").val(archives.zzmm);
                    $("#zhuanye").val(archives.zhuanye);
                    $("#minzu").val(archives.minzu);
                    $("#email").val(archives.email);
                    $("#sosperson").val(archives.sosperson);
                    $("#hiredate").val(get_date(employee.hiredate));
                    $("#positionName").val(position.name);
                    $("#dname").val(dept.dname);
                    $("#levelname").val(level.jname);
                },
            });
        });
    function commit() {
		$("#forms").submit();
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
    当前位置:档案>>个人档案信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="forms" action="${pageContext.request.contextPath}/office/archives/saveInfo" method="POST">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;个人档案信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >员工姓名：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="ename" id="ename" />
		<input type="hidden" name="eid" id="eid">
		<input type="hidden" name="dnum" id="dnum">
	</td>

	<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="esex" id="esex"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">毕业院校：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="school" name="school"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">专业：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="zhuanye" name="zhuanye"/>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >政治面貌：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="zzmm" id="zzmm"/></td>

	<td align="right" bgcolor="#FAFAF1" height="22">民族：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="minzu" id="minzu"/></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="hiredate" id="hiredate"/></td>

	<td align="right" bgcolor="#FAFAF1" height="22">紧急联系人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="sosperson" id="sosperson"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="levelname" id="levelname" readonly="true"/></td>
	</td>

	<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="positionName" id="positionName" readonly="true"/></td>
</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">部门：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input type="text" name="dname" id="dname" readonly="true"/></td>
		</td>

		<td align="right" bgcolor="#FAFAF1" height="22">邮箱：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input type="text" name="email" id="email"/></td>
	</tr>



<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130 name="remark" readonly></textarea><span id="number"></span>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<A class="coolbg" onclick="commit()" >保存</A>
	<a href="${pageContext.request.contextPath}/project/project-base" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>