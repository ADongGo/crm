<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language='javascript'>
	var curopenItem = '1';

</script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/resources/skin/js/frame/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
	<script>

        function show_open(index){
            if(index==0){
                return "block";
            }else{
                return "none"
            }
        }
        $(function(){
            //找当前用户所拥用的菜单资源
            $.ajax({
                method:"post",
                url:"${pageContext.request.contextPath}/resource/getCurrentEmployeeRoleSources",
                data:{"pid":1},
                dataType:"json",
                cache:false,
                success:function(data){
                    $(data).each(function(index,elem){
                        var dl="<dl class='bitem'>\n" +
                            "<dt onclick=showHide(\"items"+(index+1)+"_1\")><b>"+elem.name+"</b></dt>\n" +
                            "\t<dd style='display:"+show_open(index)+"' class='sitem' id=items"+(index+1)+"_1>\n" +
                            "\t\t<ul class='sitemu' id="+index+">\n" +
                            "\n" +
                            "\t\t</ul>\n" +
                            "\t</dd>\n" +
                            "</dl>";
                        $("#menuss").append(dl);
                        $(elem.children).each(function(index2,elem2){
                            var li="<li><a href=\"${pageContext.request.contextPath}"+elem2.url+"\" target=\"main\">"+elem2.name+"</a> </li>";
                            $("#"+index).append(li);
                        });

                    });
                }
            });
        });
	</script>
<base target="main" />
</head>
<body target="main">
	<table  width='99%' height="100%" border='0' cellspacing='0' cellpadding='0' >
        <tr><td style='padding-left:3px;padding-top:8px' valign='top' id="menuss">
<!--
<dl class='bitem'>
<dt onclick=showHide("items1_1")><b>项目管理</b></dt>

<dd style='display:block' class='sitem' id=items1_1>
<ul class='sitemu' id=0>
<li><a href='${pageContext.request.contextPath}/project/project-base' target='main'>基本信息管理</a> </li>
<li><a href='${pageContext.request.contextPath}/project/project-need' target='main'>需求分析管理</a> </li>
<li><a href='${pageContext.request.contextPath}/project/project-model' target='main'>模块管理</a> </li>
<li><a href='${pageContext.request.contextPath}/project/project-function' target='main'>功能管理</a> </li>
<li><a href='${pageContext.request.contextPath}/attachment/queryAttachments' target='main'>附件管理</a> </li>
</ul>
</dd>
</dl>

<dl class='bitem'><dt onclick=showHide('items2_1')><b>日常办公</b></dt><dd style='display:none' class='sitem' id=items2_1><ul class='sitemu' id=1>
<li><a href='${pageContext.request.contextPath}/office/task-add' target='main'>创建任务</a> </li>
<li><a href='${pageContext.request.contextPath}/office/task/getTaskByEmployee/task' target='main'>任务信息</a> </li>
<li><a href='${pageContext.request.contextPath}/office/task/getTaskByEmployee/task-my' target='main'>我的任务</a> </li>
<li><a href='${pageContext.request.contextPath}/office/notice/notice' target='main'>通知公告</a></li>
<li><a href='${pageContext.request.contextPath}/office/archives/archives' target='main'>档案管理</a> </li>
<li><a href='${pageContext.request.contextPath}/office/archives/myarchives' target='main'>我的档案</a> </li>
<li><a href='${pageContext.request.contextPath}/baoxiao/getBaoxiaoByStatus/1' target='main'>报销审批</a> </li>
<li><a href='${pageContext.request.contextPath}/baoxiao/queryBaoxiao' target='main'>我的报销</a> </li>
</ul></dd></dl>

<dl class='bitem'><dt onclick=showHide("items3_1")><b>消息管理</b></dt><dd style='display:none' class='sitem' id=items3_1><ul class='sitemu' id=2>
	<li><a href='${pageContext.request.contextPath}/message/email/email' target='main'>我的邮箱</a> </li>
	<li><a href='${pageContext.request.contextPath}/message/message-give' target='main'>消息推送</a> </li>
	<li><a href='${pageContext.request.contextPath}/forumpost/show' target='main'>论坛</a> </li>
</ul></dd></dl>

<dl class='bitem'><dt onclick=showHide("items4_1")><b>客户信息管理</b></dt><dd style='display:none' class='sitem' id=items4_1><ul class='sitemu' id=3>
<li><a href='${pageContext.request.contextPath}/cus/customer' target='main'>客户信息</a> </li>
</ul></dd></dl>

<dl class='bitem'><dt onclick=showHide("items5_1")><b>系统管理</b></dt><dd style='display:none' class='sitem' id=items5_1><ul class='sitemu' id=4>
<li><a href='${pageContext.request.contextPath}/emp/user' target='main'>员工管理</a> </li>
<li><a href='${pageContext.request.contextPath}/role/role' target='main'>角色管理</a> </li>
<li><a href='${pageContext.request.contextPath}/resource/resource' target='main'>菜单资源管理</a></li>
</ul></dd></dl>


<dl class='bitem'><dt onclick=showHide("items7_1")><b>对标管理</b></dt><dd style='display:none' class='sitem' id=items7_1><ul class='sitemu' id=6>
	<li><a href='${pageContext.request.contextPath}/duibiao/showDatacollect' target='main'>对标信息管理</a></li>
	<li><a href='${pageContext.request.contextPath}/duibiao/showIndexvalue' target='main'>设定指标</a></li>
	<li><a href='${pageContext.request.contextPath}/duibiao/forward/duibiao-result' target='main'>目标营业额分析</a></li>
</ul></dd></dl> 

<dl class='bitem'><dt onclick=showHide("items6_1")><b>我的信息</b></dt><dd style='display:none' class='sitem' id=items6_1><ul class='sitemu' id=5>
<li><a href='${pageContext.request.contextPath}/resources/info.jsp' target='main'>信息查看</a> </li>
<li><a href='${pageContext.request.contextPath}/resources/modpassword.jsp' target='main'>修改密码</a> </li>
</ul></dd></dl>
-->
		</td>
		</tr>
	</table>
</body>
</html>