<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发信息</title>
<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery.form.js"></script>
<LINK href="${pageContext.request.contextPath}/resources/skin/css/theAlert.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
<script type="text/javascript">

    $(function(){
        $.ajax({
			type:'GET',
            url:"${pageContext.request.contextPath}/emp/email/getEmployeeNoLogin",
            dataType:"json",
			cache:false,
            success:function(data){
                $.each(data,function(index,elem){
					  var option="<option value="+elem.eid+">"+elem.ename+"</option>"
                      $("#empFk2").append(option);
				});
            },
        });
    });
     function commit(){

         $("#form14").ajaxForm();
         $("#form14").ajaxSubmit(function(data){
             if(data.status==200) {
                     theAlert(data.msg,"alert",function(){
                         window.location="${pageContext.request.contextPath}/message/email/email";
					 });
             }else{
                 theAlert(data.msg,"alert");
             }
         });
	 }
	 
	 function setEmail() {
         var eid=$("#empFk2 option:selected").val();
		 $.ajax({
			 url:"${pageContext.request.contextPath}/office//archives/getArchivesByEid",
			 type:"post",
			 data:{"eid":eid},
			 dataType:"json",
			 cache:false,
			 success:function (archives) {
				 $("#reemp").val(archives.email);
             }
		 });
     }

</script>
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
    当前位置:信息箱>>发信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form14" name="form2" action="${pageContext.request.contextPath}/message/email/sendEmail" method="post" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;发信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">收件人：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="empFk2" id="empFk2" onchange="setEmail();">
			 <option>选取收件人</option>
		</select>

	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">收件人邮箱：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="reemp" name="reemp" size="50"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="title" size="50"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">内容：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea rows=15 cols=130 name="emailcontent"></textarea>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >附件：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<input type="file" name="file"/>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit();" class="coolbg">发送</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>