<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css">
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>

<script>
    function get_date(source){
        var date=new Date(source);
        var year=date.getFullYear();
        var month=formatDate(date.getMonth()+1);
        var day=formatDate(date.getDate());
        return year+"-"+month+"-"+day;
    }

    //首页
    function fristPage(currentPage){
        queryCustomer(currentPage);
    }
    //上一页
    function  prePage(currentPage){
        if(currentPage>1){
            queryCustomer(currentPage-1);
        }
    }
    //下一页
    function nextPage(currentPage,totalPage){
        if(currentPage<totalPage){
            queryCustomer(currentPage+1);
        }
    }
    //尾页
    function lastPage(totalPage){
        queryCustomer(totalPage);
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
           queryCustomer(1);
     });
     function queryCustomer(currentPage){
          $.ajax({
              url:"${pageContext.request.contextPath}/cus/queryCustomer",
              type:"post",
              data:{"currentPage":currentPage,"keyword":$("#keyword").val(),"searchCondition":$("#searchCondition").val(),"orderby":$("#orderby").val()},
              dataType:"json",
              cache:false,
              success:function(result){

                  //清除以前的数据
                  $("#content tr:not(:lt(2)):not([id=showData])").remove();

                  $.each(result.records,function(index,element){
                      var tr="<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                          "\t<td><input name=\"ids\" type=\"checkbox\" value=\""+element.id+"\" class=\"np\"></td>\n" +
                          "\t<td>"+((result.currentPage-1)*result.pageSize+index+1)+"</td>\n" +
                          "\t<td>"+element.companyperson+"</td>\n" +
                          "\t<td align=\"center\">"+element.comname+"</td>\n" +
                          "\t<td>"+get_date(element.addtime)+"</td>\n" +
                          "\t<td>"+element.comphone+"</td>\n" +
                          "\t<td> <a href=\"${pageContext.request.contextPath}/cus/queryCustomerById/customer-look?id="+element.id+"\">查看详情</a></td>\n" +
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



     function selectAll(){
          var oCheckbox=$("input[name=ids]");
          $.each(oCheckbox,function(index,element){
              element.checked=true;
          });
     }

     function unSelectAll(){
         var oCheckbox=$("input[name=ids]");
         $.each(oCheckbox,function(index,element){
             if(element.checked){
                 element.checked=false;
             }else{
                 element.checked=true;
             }
         });
     }



     function updateCustomer(){
         var oCheckbox=$("input[name=ids]:checked");
         if(oCheckbox.length!=1){

             theAlert("只能选择一条记录进行修改","alert",function(){});
         }else{
             var id=oCheckbox[0].value;
             window.location="${pageContext.request.contextPath}/cus/queryCustomerById/customer-edit?id="+id;
         }
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
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/cus/customer-add';" value='添加客户信息' />
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
          <select id="searchCondition" name='searchCondition' style='width:150px'>
              <option value="0">选择类型...</option>
              <option value='1'>客户所在公司名称</option>
              <option value='2'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' id="keyword" name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select id="orderby" name='orderby' style='width:120px'>
            <option value="0">排序...</option>
            <option value='1'>添加时间升序</option>
            <option value='2'>添加时间降序</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<a href="javascript:queryCustomer(1);"><img  src="${pageContext.request.contextPath}/resources/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" /></a>
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
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>
<!--
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>1</td>
	<td>李彦宏</td>
	<td align="center">百度</td>
	<td>2015-02-03</td>
	<td>13257634888</td>
	<td><a href="customer-edit.jsp">编辑</a> | <a href="customer-look.jsp">查看详情</a></td>
</tr>
-->

<tr bgcolor="#FAFAF1" id="showData">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:selectAll();" class="coolbg">全选</a>
	<a href="javascript:unSelectAll();" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:updateCustomer();" class="coolbg">&nbsp;编辑&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:void(0);" class="coolbg">&nbsp;删除&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:void(0);" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
    <!--
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"></td>
</tr>
-->
</table>

</form>
  

</body>
</html>