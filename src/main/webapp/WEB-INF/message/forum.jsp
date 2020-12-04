<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>main</title>
    <base target="_self">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/main.css" />

    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">

<%--
        $(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/forumpost/showYi",
                type:"post",
                dataType:"json",
                cache:false,
                success:function (result) {
                    $.each(result,function (index,forumpost) {
                        var tr="\n"+setTr(index)+"\n" +
                            "        <td>\n" +
                            "            <ul class=\"notice-list\">\n" +
                            "                <li class=\"ue-clear\">\n" +
                            "                    <span><img src=\""+forumpost.employee.pic+"\" height=\"50px\" width=\"50px\"/></span>\n" +
                            "                    <a href=\"${pageContext.request.contextPath}/forumpost/getForumpostByFroumId?forumid="+forumpost.forumid+"\"class=\"notice-title\">"+forumpost.forumtitle+"</a>\n" +
                            "                </li>\n" +
                            "            </ul>\n" +
                            "        </td>\n" +
                            "        "+setTr1(index)+"\n";

                        $("#showData").before(tr);
                    })
                }
            });
        });
--%>
    </script>

</head>
<body leftmargin="8" topmargin='8'>

<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr >
        <td colspan="3" background="${pageContext.request.contextPath}/resources/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'>
            <span>员工论坛</span> |<span>生活广场</span> |<span>租房信息</span><a href='${pageContext.request.contextPath}/forumpost/forum-add' style='padding-left: 1260px'><font size="5">发帖</font></a>
        </td>
    </tr>

    <c:forEach var="forumpost" items="${forumposts}" varStatus="st">
        <c:if test="${st.index%3==0}">
            <tr bgcolor="#FFFFFF">
        </c:if>
        <td>
            <ul class="notice-list">
                <li class="ue-clear">
                    <span><img src="${forumpost.employee.pic}" height="50px" width="50px"/></span> 发布时间：<fmt:formatDate value="${forumpost.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    <a href="${pageContext.request.contextPath}/forumpost/getForumpostByFroumId?forumid=${forumpost.forumid}"class="notice-title">${forumpost.forumtitle}</a>
                </li>
            </ul>
        </td>
        <c:if test="${(st.index+1)%3==0}">
            </tr>
        </c:if>
    </c:forEach>

    <tr bgcolor="#FAFAF1" id="showData"></tr>
</table>

</body>
</html>