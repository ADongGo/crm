<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>项目信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>

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
        $(function () {
            queryProject(1);
        });
        //首页
        function fristPage(currentPage){
            queryProject(currentPage);
        }
        //上一页
        function prePage(currentPage) {
            if(currentPage>1){
                queryProject(currentPage-1);
            }
        }
        //下一页
        function nextPage(currentPage,totalPage) {
            if(currentPage<totalPage){
                queryProject(currentPage+1);
            }
        }
        //尾页
        function lastPage(totalPage) {
            queryProject(totalPage);
        }

        function queryProject (currentPage) {
           $.ajax({
               url:"${pageContext.request.contextPath}/project/showProject",
               type:"post",
               data:{"currentPage":currentPage,"searchC":$("#searchC").val(),"keyword":$("#keyword").val(),"orderby":$("#orderby").val()},
               dataType:"json",
               cache:false,
               success:function (result) {
                   $("#content tr:not(:lt(2)):not([id=showData])").remove();
                   $.each(result.records,function (index,element) {
                       var tr="<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                           "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                           "\t<td>"+((result.currentPage-1)*result.pageSize+index+1)+"</td>\n" +
                           "\t<td align=\"left\"><a href=''><u>"+element.pname+"</u></a></td>\n" +
                           "\t<td>"+element.customer.comname+"</td>\n" +
                           "\t<td>"+element.customer.companyperson+"</td>\n" +
                           "\t<td>"+element.employee.ename+"</td>\n" +
                           "\t<td>"+element.empcount+"</td>\n" +
                           "\t<td>"+get_date(element.buildtime)+"</td>\n" +
                           "\t<td>"+get_date(element.starttime)+"</td>\n" +
                           "\t<td>"+get_date(element.endtime)+"</td>\n" +
                           "\t<td>"+element.level+"</td>\n" +
                           "\t<td><a href=\"${pageContext.request.contextPath}/project/getProjectById?pid="+element.pid+"\">编辑</a> | <a href=\"${pageContext.request.contextPath}/project/getProjectById?pid="+element.pid+"\">查看详情</a></td>\n" +
                           "</tr>";
                           $("#showData").before(tr);
                   });
                   var cutPageCodeTr="  <tr align=\"right\" bgcolor=\"#EEF4EA\">\n" +
                       "        <td height=\"36\" colspan=\"12\" align=\"center\">\n" +
                       "            <a href=\"javascript:fristPage(1)\">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                       "            <a href=\"javascript:prePage("+result.currentPage+")\">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                       "            <a href=\"javascript:nextPage("+result.currentPage+","+result.totalPage+")\">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                       "            <a href=\"javascript:lastPage("+result.totalPage+")\">尾页</a>\n" +
                       "        </td>\n" +
                       "    </tr>";
                   $("#showData").after(cutPageCodeTr);
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
    当前位置:项目管理>>基本信息管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/project/project-base-add';" value='添加新项目' />
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
          <select name='searchC' id="searchC" style='width:150'>
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>项目经理</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' id="keyword" name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' id="orderby" style='width:120px'>
            <option value='0'>排序...</option>
            <option value='1'>立项时间</option>
            <option value='2'>计划完成时间</option>
      	</select>
        </td>
        <td>
            &nbsp;&nbsp;&nbsp;<a href="javascript:queryProject(1);"><img src="${pageContext.request.contextPath}/resources/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" /></a>
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
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">项目名称</td>
	<td width="10%">客户公司名称</td>
	<td width="10%">客户方负责人</td>
	<td width="5%">项目经理</td>
	<td width="8%">开发人员数</td>
	<td width="6%">立项时间</td>
	<td width="8%">开始时间</td>
	<td width="8%">计划完成时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>
<tr bgcolor="#FAFAF1" id="showData">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
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