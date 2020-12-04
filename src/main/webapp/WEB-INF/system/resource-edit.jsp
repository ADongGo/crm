<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>

    <script type="text/javascript">
        $(function () {
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath}/resource/getOneSource',
                data: {"id": ${id}},
                dataType: 'json',
                success: function (rs) {
                    $("#sname").val(rs.name);

                    if(rs.url!=null){
                        $("#ttr").show();
                        $("#surl").val(rs.url);
                    }
                    $("#sremark").val(rs.remark);
                    $("#pid").val(rs.pid);
                }

            });

        });


        function commit() {
            $.ajax({
                type:"post",
                url:$("#form14").attr("action"),
                data:$("#form14").serialize(),
                dataType:"json",
                cache:false,
                success:function(data){
                    if(data.status==200){
                        theAlert(data.message,"alert",function(){
                            window.location="${pageContext.request.contextPath}/resource/resource";
                        });

                    }else {
                        theAlert(data.message,"alert");
                    }
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
                    <td>
                        当前位置:权限管理>>修改菜单资源
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


<!--  内容列表   -->
<form name="form2" id="form14" action="${pageContext.request.contextPath}/resource/updateSource" method="post">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="pid" id="pid">
    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;修改资源&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="name" id="sname"/></td>
        </tr>
        <tr  id="ttr">
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源路径：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="url" id="surl" size="80"/></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1">资源描述：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="remark" id="sremark"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:commit()" class="coolbg">保存</a>
                <a href="${pageContext.request.contextPath}/resource/resource" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>


</body>
</html>