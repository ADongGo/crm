<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加需求分析信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/utf8-jsp/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <script type="application/javascript">
        var ue = UE.getEditor('editor');

        function commit() {
            $("#form15").submit();
        }
    </script>
    <style type="text/css">
        div {
            width: 100%;
        }
    </style>
    <script type="text/javascript">
         function setReplay(evaid){
             $("#evaidFk").val(evaid);
         }
    </script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/resources/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" c1ellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="${pageContext.request.contextPath}/resources/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:论坛>>评论
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<div>
    <form name="form2" action="${pageContext.request.contextPath}/forumpost/evaluate/add" id="form15" method="post">
        <input type="hidden" value="${forum.forumid}" name="forumfk">
        <input type="hidden"  name="evaidfk" id="evaidFk">
        <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
               style="margin-top:8px">
            <tr bgcolor="#E7E7E7">
                <td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;评论&nbsp;</td>
            </tr>
            <tr>
                <td align="right" bgcolor="#FAFAF1" height="22">
				<span>
					<img src='${forum.employee.pic}' height='50px' width='50px'/>
				</span>
               </td>

                <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                    <span>发布人：${forum.employee.ename}</span><br>
                    <span>发布时间:<fmt:formatDate value="${forum.createtime}" pattern="yyyy-MM-dd HH :mm:ss"></fmt:formatDate>  </span><br>
                    <span>标题：${forum.forumtitle}</span><br>
                    <span>内容:${forum.forumcontent}</span>
                </td>
            </tr>
            <!-- 遍历评论 -->
            <c:forEach items="${forum.evaluateList}" var="evaluate">
            <tr>
                <td align="right" bgcolor="#FAFAF1" height="22">
					<span>
						<img src='${evaluate.employee.pic}' height='50px' width='50px'/>
					</span>
                </td>
                <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                    <span>评论人：${evaluate.employee.ename}&nbsp;&nbsp;回复了 ${evaluate.employee2.ename}&nbsp;&nbsp;</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span>评论时间：<fmt:formatDate value="${evaluate.evatime}" pattern="yyyy-MM-dd HH :mm:ss"></fmt:formatDate> </span><br>
                    <span>评论内容:${evaluate.evacontent}</span>
                    &nbsp;<span><a href="javascript:setReplay(${evaluate.evaid});">【回复】</a></span>
                </td>
            </tr>
            </c:forEach>



            <!-- 添加空行 -->
            <% for (int i = 0; i < 3; i++) {%>
            <tr>
                <td align="right" bgcolor="#FAFAF1" height="22"></td>
                <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                </td>
            </tr>
            <% } %>



            <tr>
                <td align="right" bgcolor="#FAFAF1" height="22">我也说两句：</td>
                <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                    onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                    <script id="editor" name="evacontent" type="text/plain" style="width:1024px;height:100px;"></script></td>
            </tr>
            <tr bgcolor="#FAFAF1">
                <td height="28" colspan=4 align=center>
                    &nbsp;
                    <a href="javascript:commit()" class="coolbg">评论</a>
                    <a href="project-need.jsp" class="coolbg">返回</a>
                </td>
            </tr>

        </table>
    </form>

</div>

</body>
</html>