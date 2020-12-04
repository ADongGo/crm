<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>对标管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
            $(function(){
                $.ajax({
					type:'GET',
					url:'${pageContext.request.contextPath}/duibiao/showAllIndexValue',
					dataType:'json',
					success:function (rs) {
						$(rs).each(function(index,item){
                            var date = new Date(item.inStarttime);
                            var date1 = new Date(item.inEndtime);
                            var time= date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                            var time1 = date1.getFullYear()+"-"+(date1.getMonth()+1)+"-"+date1.getDate();
							var filename = item.inFile.substring(item.inFile.lastIndexOf("\\")+1, item.inFile.length);
							alert(filename);
						    var tr ="<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                                "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                                "\t<td>"+item.inId+"</td>\n" +
                                "\t<td><a href=''><u>"+item.datacollect.dacname+"</u></a></td>\n" +
                                "\t<td>"+item.inTurnover+"亿</td>\n" +
                                "\t<td>"+item.employee.ename+"</td>\n" +
                                "\t<td>"+time+"</td>\n" +
                                "\t<td>"+time1+"</td>\n" +
                               "\t<td><a href=\"${pageContext.request.contextPath}/duibiao/download?filename="+filename+"\">附件下载</a> |<a href=\"project-base-edit.jsp\">编辑</a> | <a href=\"project-base-look.jsp\">查看详情</a></td>\n" +
                                "</tr>";

                                 $("#ttr").after(tr);

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
    当前位置:对标管理>>添加指标信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/duibiao/forward/indexvalue-add';" value='添加指标信息' />
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
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;指标信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" id="ttr">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="15%">目标公司</td>
	<td width="15%">目标营业额</td>
	<td width="15%">指标制定人</td>
	<td width="15%">指标开始时间</td>
	<td width="15%">指标截止时间</td>
	<td width="15%">操作</td>
</tr>
<c:forEach items="${indexvalueList}" var="indexvalue">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>${indexvalue.inId}</td>
	<td><a href=''><u>${indexvalue.datacollect.dacname}</u></a></td>
	<td>${indexvalue.inTurnover}</td>
	<td>${indexvalue.employee.ename}</td>
	<td><fmt:formatDate value="${indexvalue.inStarttime}" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${indexvalue.inEndtime}" pattern="yyyy-MM-dd"/></td>
	<td><a href="project-base-edit.jsp">附件下载</a> |<a href="project-base-edit.jsp">编辑</a> | <a href="project-base-look.jsp">查看详情</a></td>
</tr>
</c:forEach>

<tr bgcolor="#FAFAF1">
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