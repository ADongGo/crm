<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>编辑角色信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">

    <script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/docs.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ztree/jquery.ztree.all-3.5.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ztree/zTreeStyle.css">

    <script type="application/javascript">
        $(function () {

            //显示当前id对应的角色的全部信息
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath}/role/showOneRole',
                data: {"roleid":${roleid}},
                dataType: 'json',
                catch:false,
                success:function(rs){
                      $("#roleid").val(rs.role.roleid);
                      $("#rolename").val(rs.role.rolename);
                      $("#status").val(rs.role.status);
                      $("#roledis").val(rs.role.roledis);
                      if(rs.role.status == 1){
                          $("option[id='op1']").attr("selected",true);
                      }
                     var setting = {
                        check: {
                            enable: true
                        },
                        async: {
                            enable: true,
                            url: "${pageContext.request.contextPath}/resource/getRootSources",
                            autoParam: ["id", "name=n", "level=lv"],

                        },
                         data: {
                             simpleData: {
                                 enable: true,
                                 idKey: 'id',
                                 pIdKey: 'pid',
                                 rootPId: 0
                             }
                         },
                         callback:{
                             onAsyncSuccess: function zTreeOnAsyncSuccess(event, treeId, treeNode, message) {
                                 //获取我们的ztree对象
                                 var var_zTree = $.fn.zTree.getZTreeObj("permissionTree");
                                 $(rs.sourcesId).each(function(index,item){
                                     //获取我们要进行勾选的节点
                                     var node = var_zTree.getNodeByParam("id",item.sid,null);
                                     if(node != null) {
                                         // checkNode(节点对象,是否否选这个节点 true勾选  false 取出勾选)
                                         var_zTree.checkNode(node,true);
                                         //如果有被勾选选项，我们就展开我们勾选的菜单
                                         var_zTree.selectNode(node); //打开选中节点的父节点
                                     }
                                 });
                             }
                         }

                     };
                     $.fn.zTree.init($("#permissionTree"), setting);


                }
            });


            $("#myButton").click(function () {
                // 获取我们的树
                var treeObj = $.fn.zTree.getZTreeObj("permissionTree");

                // 获取被选中的节点
                var nodes = treeObj.getCheckedNodes(true);
                if (0 === nodes.length) {
                    alert("请给当前角色添加资源!");
                    return;
                }
                //将所有的选中的组件的id使用字符串连接方式拼接成一个字符串
                var dataNodes = "";
                for (var i = 0; i < nodes.length; i++) {
                    dataNodes += nodes[i].id + ",";
                }
                dataNodes=dataNodes.substring(0,dataNodes.length-1);
                //将拼接的结果赋值给表单中的一个变量
                $("#sid").val(dataNodes);
                //提交表单
                //$("#form19").submit();

                //更新权限
                //提交表单
                $.ajax({
                    type:"post",
                    url:$("#form19").attr("action"),
                    data:$("#form19").serialize(),
                    dataType:"json",
                    cache:false,
                    success:function(data){
                        if(data.status==200){
                            theAlert(data.message,"alert",function(){
                                window.location="${pageContext.request.contextPath}/role/role";
                            });

                        }else {
                            theAlert(data.message,"alert");
                        }
                    }
                });
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
                    <td>
                        当前位置:权限管理>>编辑角色
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form id="form19" name="form2" action="${pageContext.request.contextPath}/role/updateRole" method="post">
     <input type="hidden" id="sid" name="sourcesid">
    <input type="hidden" name="mark" value="2">
    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;编辑角色&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input id="roleid" name="roleid" readonly="true"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="rolename" id="rolename"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" id="ss" name="status">
            <select name="status" id="status">
                <option value=1 id="op1">启用</option>
                <option value=0 id="op2">禁用</option>
            </select></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <div class="panel-body">
                    <%--盛放树的容器--%>
                    <ul id="permissionTree" class="ztree"></ul>
                </div>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="roledis" id="roledis"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="#" id="myButton" class="coolbg">更新</a>
                <a href="${pageContext.request.contextPath}/role/role" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>


</body>
</html>