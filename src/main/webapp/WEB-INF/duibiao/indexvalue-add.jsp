<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加对标信息</title>
<LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
<script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>

<link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.css" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/demos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<!--中文-->
<script src="${pageContext.request.contextPath}/resources/datejs/js/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/resources/datejs/js/jquery-ui-timepicker-zh-CN.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript" charset="UTF-8"></script>
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
            // 时间设置

            //加载对标企业名称
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/duibiao/getInfoGroup',
                dataType:'json',
                success:function(resultData){
                    $(resultData).each(function(index,item){
                          var option="<option value="+item.dacname+">"+item.dacname+"</oiption>";
                           $("#com").append(option);
                    });
                }
            });
        });

        //加载对标企业信息
        function showInfo(obj){

            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/duibiao/getOneByCname',
				data:{"dacname":obj},
                dataType:'json',
                success:function(resultData){
                     console.info(resultData);
                     $("#cname1").val(resultData.one.dacname);
                     $("#money1").val(resultData.one.daturnover);
                     $("#maindo1").val(resultData.one.dabusiness);
                     $("#good1").val(resultData.one.dasuperiority);
                     $("#nogood1").val(resultData.one.dainforiority);
                     $("#po1").val(resultData.one.dasort);
                     $("#count1").val(resultData.one.empcount);
                     $("#build1").val(get_date(resultData.one.buildtime));
                     $("#remark1").val(resultData.one.remark);
                     $("#attachment").text(resultData.one.daother);
                     $("option[name='a']").remove();
                     $(resultData.list).each(function(index,item){
                          var date = new Date(item.datime);
                          var info = date.getFullYear()+"-"+date.getMonth()+1+"-"+date.getDate();
                         var option = "";
                          if(resultData.one.datime == item.datime ){
                              option="<option name='a' selected  value="+item.daid+">"+info+"</oiption>";
						  }else{
                              option="<option name='a'  value="+item.daid+">"+info+"</oiption>";
						  }
                         $("#ymd").append(option);
					 });
                     // 表单数据
                     $("#pname").val(resultData.one.dacname);
                     $("#comnameFk").val(resultData.one.daid);
                }
            });
		}

		function showInfoBydaid(obj){
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/duibiao/getOneBydaid',
                data:{"daid":obj},
                dataType:'json',
                success:function(resultData){
                    console.info(resultData.one);
                    $("#cname1").val(resultData.one.dacname);
                    $("#money1").val(resultData.one.daturnover);
                    $("#maindo1").val(resultData.one.dabusiness);
                    $("#good1").val(resultData.one.dasuperiority);
                    $("#nogood1").val(resultData.one.dainforiority);
                    $("#po1").val(resultData.one.dasort);
                    $("#count1").val(resultData.one.empcount);
                    $("#build1").val(get_date(resultData.one.buildtime));
                    $("#remark1").val(resultData.one.remark);
                    $("#attachment").text(resultData.one.daother);

                    $("option[name='a']").remove();
                    $(resultData.list).each(function(index,item){
                        var date = new Date(item.datime);
                        var info = date.getFullYear()+"-"+date.getMonth()+1+"-"+date.getDate();
                        var option = "";
                        if(resultData.one.datime == item.datime ){
                            option="<option name='a' selected  value="+item.daid+">"+info+"</oiption>";
                        }else{
                            option="<option name='a'  value="+item.daid+">"+info+"</oiption>";
                        }
                        $("#ymd").append(option);
                    });
                    // 表单数据
                    $("#pname").val(resultData.one.dacname);
                    $("#comnameFk").val(resultData.one.daid);
                }
            });
		}

		function commit(){

            $("#form17").submit();


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
    当前位置:对标管理>>添加对标基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<div>

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="40" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">
				<h1>选择对标企业：</h1>
				<select id="com"  onchange="showInfo(this.value)">
					<option>选择对标企业</option>
				</select>

			</td>
		</tr>
	</table>


	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;<font color="red">对标企业信息如下</font>&nbsp;</td>
		</tr>
		<tr >

			<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="pname" id="cname1" readonly/>
			</td>

			<td align="right" bgcolor="#FAFAF1" height="22" >营业额：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" id="money1" readonly/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">年份：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

				<h1>选择对标年份：</h1>
				<select id="ymd" onchange="showInfoBydaid(this.value)">
					<option>选择对标年份</option>
				</select>
			</td>

			<td align="right" bgcolor="#FAFAF1" height="22">主要业务：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				  <textarea rows="3" cols="18" id="maindo1" readonly></textarea>
			</td>
		</tr>


		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22" >优势：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<textarea rows="3" cols="18" id="good1" readonly></textarea>
			</td>
			<td align="right" bgcolor="#FAFAF1" height="22">劣势：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<textarea rows="3" cols="18" id="nogood1" readonly></textarea>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">行业地位：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="buildtime" id="po1" readonly/>
			</td>
			<td align="right" bgcolor="#FAFAF1" height="22">员工数量：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="cost" id="count1" readonly/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">创建时间：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="cost" id="build1" readonly/>
			</td>
			<td align="right" bgcolor="#FAFAF1" height="22"></td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

			</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >简单描述：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea type="text" rows=15 cols=130 id="remark1" readonly></textarea>
			</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >附件下载：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				  <a href="#" id="attachment"></a>
			</td>
		</tr>
	</table>
</div>




<!-- 添加指标 -->

<form name="form17" id="form17" action="${pageContext.request.contextPath}/duibiao/saveIndexValueInfo" method="POST" enctype="multipart/form-data">
	    <!-- 向后台传递的关联外键 -->
        <input type="hidden" id="comnameFk"  name="comnameFk">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;<font color="red">添加对标信息</font>&nbsp;</td>
</tr>
  <tr >
	<td align="right" bgcolor="#FAFAF1" height="22">目标公司：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" id="pname" readonly/>
	</td>

	<td align="right" bgcolor="#FAFAF1" height="22" >目标营业额：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="inTurnover"/>
	</td>

</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">业务方向：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="cp" name="inBusiness"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="datetime" class="time" name="inStarttime" id="inStarttime" onfocus="WdatePicker({el:'inStarttime'})" readonly="readonly"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >截止时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="datetime" class="time" name="inEndtime" id="inEndtime" onfocus="WdatePicker({el:'inEndtime'})" readonly="readonly"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22"></td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"></td>
</tr>


<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130 name="inRemark"></textarea><span id="number"></span>
	</td>
</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" >上传详细计划书：</td>
		<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
			<input type="file" name="files" >
		</td>
	</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a class="coolbg" onclick="commit()" >保存</a>
	<a href="${pageContext.request.contextPath}/duibiao/showIndexvalue" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>