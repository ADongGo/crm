<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/main.css" />
<script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
<script>
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
    <!-- 异步显示三条数据-->
    $(function () {
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/office/notice/getNoticesByFlag",
            data:{"flag":3},
            dataType:"json",
            cache:false,
            success:function(result){
                $.each(result,function(index,element){
                    var li="<li class=\"ue-clear\">\n" +
                        "\t\t\t\t\t<span>"+get_date(element.ndate)+"</span>&nbsp;&nbsp;&nbsp;<a href=\"javascript:showWindow("+element.nid+")\"class=\"notice-title\">"+element.ntitle+"</a>\n" +
                        "\t\t\t\t\t</li>";
                    $("#notices").append(li);
                });
            }
        });
    });

    //查询最新的前9条帖子
    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/forumpost/forumpostTop9",
        data:{"flag":9},
        dataType:"json",
        cache:false,
        success:function(data){
            var tr="";
            var td="";
            $(data).each(function(index,elem){

                td=td+"<td>\n" +
                    "\t\t\t\t<ul class=\"notice-list\">\n" +
                    "\t\t\t\t\t<li class=\"ue-clear\">\n" +
                    "\t\t\t\t\t\t<span><img src=\""+elem.employee.pic+"\" height=\"50px\" width=\"50px\"/></span> 发布时间："+get_date(elem.createtime)+"\n" +
                    "\t\t\t\t\t\t<a href=\"${pageContext.request.contextPath}/forumpost/getForumpostByFroumId?forumid="+elem.forumid+"\"class=\"notice-title\">"+elem.forumtitle+"</a>\n" +
                    "\t\t\t\t\t</li>\n" +
                    "\t\t\t\t</ul>\n" +
                    "\t\t\t</td>";

                if((index+1)%3==0 || (index+1)==$(data).length){
                    tr="<tr bgcolor=\"#FFFFFF\">";
                    tr=tr+td+"</tr>";
                    $("#forum").before(tr);
                    tr="";
                    td="";
                }
            });
        }
    });

    // 弹窗
    function showWindow(nid) {

        $('#showdiv').show();  //显示弹窗
        $('#cover').css('display','block'); //显示遮罩层
        $('#cover').css('height',document.body.clientHeight+'px'); //设置遮罩层的高度为当前页面高度

        //查询该条记录并把相的属性值放到弹窗中
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/office/notice/getNoticeByNid",
            data:{"nid":nid},
            dataType:"json",
            cache:false,
            success:function(data){

                $("#ntitle").html("<h2>"+data.ntitle+"</h2>");
                $("#content").html(data.remark);
            }
        });
    }
    // 关闭弹窗
    function closeWindow() {
        $('#showdiv').hide();  //隐藏弹窗
        $('#cover').css('display','none');   //不显示遮罩层
    }
</script>

</head>
<body leftmargin="8" topmargin='8'>

<!-- 遮罩层 -->
<div id="cover" style="background: #000; position: absolute; left: 0px; top: 0px; width: 100%; filter: alpha(opacity=30); opacity: 0.3; display: none; z-index: 2 ">

</div>
<!-- 弹窗 -->
<div id="showdiv" style="width: 60%; margin: 0 auto; height:500px; border: 1px solid #999; display: none; position: absolute; top: 20%; left: 20%; z-index: 3; background: #fff">
	<!-- 标题 -->
	<div id="ntitle" style="background: #F8F7F7; width: 100%; height: 2rem; font-size: 0.65rem; line-height: 2rem; border: 1px solid #999; text-align: center;" >

	</div>
	<!-- 内容 -->
	<div id="content" style="text-indent: 50px; height: 4rem; font-size: 0.5rem; padding: 0.5rem; line-height: 1rem; ">

	</div>
	<!-- 按钮 -->
	<div style="background: green; width: 10%; margin: 0 auto; height: 1.5rem; line-height: 1.5rem; text-align: center;color: #fff;margin-top: 28rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem;font-size: .59733rem;cursor: pointer" onclick="closeWindow()">
		关闭
	</div>
</div>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="${pageContext.request.contextPath}/resources/skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用项目平台管理系统
				</div>
				<div style='float: right; padding-right: 8px;'>
					<!--  //保留接口  -->
				</div></td>
		</tr>
		<tr>
			<td height="1" background="${pageContext.request.contextPath}/resources/skin/images/frame/sp_bg.gif"
				style='padding: 0px'></td>
		</tr>
	</table>

    <table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
		<tr>
			<td colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif"
				bgcolor="#EEF4EA" class='title'>
				<div style='float: left'>
					<span>快捷操作</span>
				</div>
				<div style='float: right; padding-right: 10px;'></div>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td height="30" colspan="2" align="center" valign="bottom"><table
					width="100%" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td width="15%" height="31" align="center"><img
                                src="${pageContext.request.contextPath}/resources/skin/images/frame/qc.gif" width="90" height="30" /></td>
						<td width="85%" valign="bottom"><div class='icoitem'>
								<div class='ico'>
									<img src='${pageContext.request.contextPath}/resources/skin/images/frame/addnews.gif' width='16' height='16' />
								</div>
								<div class='txt'>
									<a href='${pageContext.request.contextPath}/project/project-base'><u>查看项目信息</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='${pageContext.request.contextPath}/resources/skin/images/frame/menuarrow.gif' width='16'
                                         height='16' />
								</div>
								<div class='txt'>
									<a href='${pageContext.request.contextPath}/office/task/getMyTaskByEmployee'><u>查看任务</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='${pageContext.request.contextPath}/resources/skin/images/frame/file_dir.gif' width='16'
                                         height='16' />
								</div>
								<div class='txt'>
									<a href='${pageContext.request.contextPath}/message/email/email'><u>我的邮箱</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='${pageContext.request.contextPath}/resources/skin/images/frame/part-index.gif' width='16'
                                         height='16' />
								</div>
								<div class='txt'>
									<a href='${pageContext.request.contextPath}/office/archives/myarchives'><u>个人信息</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='${pageContext.request.contextPath}/resources/skin/images/frame/manage1.gif' width='16' height='16' />
								</div>
								<div class='txt'>
									<a href='${pageContext.request.contextPath}/emp/modpassword'><u>修改密码</u></a>
								</div>
							</div></td>
					</tr>
				</table></td>
		</tr>
	</table>



	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
                class='title'><span>待完成任务</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>您有<a href=""><font color="red">2</font></a>个任务未完成……&nbsp;
			</td>
		</tr>
	</table>



	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
                class='title'><span>未读消息</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>您有<a href=""><font color="red">10</font></a>条未读消息……&nbsp;
			</td>
		</tr>
	</table>


	

	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
                class='title'><span>通知公告</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>
				<ul class="notice-list" id="notices">

				</ul>
			</td>
		</tr>
	</table>

    <table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
                class='title'><span>员工论坛</span></td>
			<td  background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				 class='title'></td>
			<td  background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				 class='title' align="right"> <a>更多>></a></td>
		</tr>

		<tr id="forum"></tr>
	</table>

</body>
</html>