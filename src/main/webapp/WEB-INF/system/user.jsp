<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css"/>
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
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
    //删除
    function  deleteInfo(obj){
        theAlert("确认删除当前员工么?","confirm",function(r){
            if(r){
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/emp/deleteEmployeeById?eid="+obj,
                    dataType:"json",
                    cache:false,
                    success:function(data){
                        if(data.status==200){

                            alert(data.message);
                            window.location="${pageContext.request.contextPath}/emp/user";

                        }else {
                            theAlert(data.message,"alert");
                        }
                    }
                });
            }
        });

    }
      $(function(){
          $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/emp/getEmployeeAllInfo",
              dataType:"json",
              cache:false,
              success:function(data){
                  $("#content tr:not(:lt(2)):not([id=showData])").remove();
                  $(data).each(function(index,element){

                      var tr="<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                          "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                          "\t<td>"+(index+1)+"</td>\n" +
                          "\t<td>"+element.ename+"</td>\n" +
                          "\t<td align=\"center\">"+element.position.name+"</td>\n" +
                          "\t<td>"+element.esex+"</td>\n" +
                          "\t<td>"+element.eage+"</td>\n" +
                          "\t<td>"+element.telephone+"</td>\n" +
                          "\t<td>"+get_date(element.hiredate)+"</td>\n" +
                          "\t\t<td><a href='javascript:deleteInfo("+element.eid+")'>删除</a> | <a href=\"${pageContext.request.contextPath}/emp/getEmployeeById?eid="+element.eid+"\">编辑</a> | <a href=\"user-look.jsp\">查看详情</a></td>\n" +
                          "</tr>";

                      $("#showData").before(tr);
                  });
              }
          });
      });
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
    当前位置:权限管理>>用户管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/emp/user-add';" value='添加用户' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='${pageContext.request.contextPath}/resources/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150'>
          <option value='0'>选择类型...</option>
          	<option value='1'>姓名</option>
          	<option value='1'>联系电话</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>添加时间</option>
            <option value='pubdate'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/resources/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table id="content" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;用户列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">姓名</td>
	<td width="10%">职位</td>
	<td width="10%">性别</td>
	<td width="10%">年龄</td>
	<td width="10%">联系电话</td>
	<td width="8%">入职时间</td>
	<td width="10%">操作</td>
</tr>




<tr bgcolor="#FAFAF1" id="showData">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;注销&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>