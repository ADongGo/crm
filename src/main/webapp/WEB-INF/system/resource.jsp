<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
    <script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/docs.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ztree/jquery.ztree.all-3.5.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/skin/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <LINK href="${pageContext.request.contextPath}/resources/skin/js/theAlert.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/skin/js/theAlert.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ztree/zTreeStyle.css">
<script type="text/javascript">
       $(function(){
	     var setting = {
				async: {
					enable: true,
					url:"${pageContext.request.contextPath}/resource/getRootSources"
					//autoParam:["id", "name=n", "level=lv"]
				 },
				view: {
					addHoverDom: function(treeId, treeNode){
					    console.info(treeNode.name+":"+treeNode.id+":"+treeNode.url);
						var aObj = $("#" + treeNode.tId + "_a"); // tId = permissionTree_1, ==> $("#permissionTree_1_a")
						aObj.attr("href", "javascript:void(0);");
                        aObj.attr("target","_self");
						if (treeNode.editNameFlag || $("#btnGroup"+treeNode.tId).length>0) return;
						var s = '<span id="btnGroup'+treeNode.tId+'">';
						if ( treeNode.level == 0 ) {
							s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="addNode('+treeNode.id+')" href="#" target="_self">&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
						} else if ( treeNode.level == 1 ) {
							s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  onclick="editNode('+treeNode.id+')" href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
							if (treeNode.children.length == 0) {
								s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="deleteNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
							}
							s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="addNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
						} else if ( treeNode.level == 2 ) {
							s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  onclick="editNode('+treeNode.id+')" href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
							s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="deleteNode('+treeNode.id+')" href="#">&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="addNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
						}		
						s += '</span>';
						aObj.after(s);
					},
					removeHoverDom: function(treeId, treeNode){
						$("#btnGroup"+treeNode.tId).remove();
					}
				}
		  };
	        $.fn.zTree.init($("#permissionTree"), setting);
		 
      });
        //添加节点
       function addNode(id){
           //点击添加连接,跳转到我们的添加页面
    	   window.location.href = "${pageContext.request.contextPath}/resource/resource-add?id="+id;
       }


       //编辑节点 更新节点
       function editNode(id) {
           // 跳转到了一个控制器方法,控制方法查询出我们当前这个数据,展示到我们的页面
       	   window.location.href = "${pageContext.request.contextPath}/resource/resource-edit?id="+id;
       }


       
       //删除节点
       function deleteNode(id){
    	   layer.confirm("删除资源信息, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
				// 删除选择的用户信息
				$.ajax({
					type : "POST",
					url  : "${pageContext.request.contextPath}/resource/deleteSourcesById",
					data : {id : id},
                    cache:false,
					success : function(data) {
						if (data.status==200) {

						    theAlert(data.message,"alert",function(){
                                // 刷新数据 获取树对象
                                var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
                                //刷新我们的树
                                treeObj.reAsyncChildNodes(null, "refresh");
                            });


						} else {
                             layer.message("资源信息删除失败", {time:2000, icon:5, shift:6}, function(){
                           });
						}
					}
				});			
				layer.close(cindex);
			},function(cindex){
			    layer.close(cindex);
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
    当前位置:权限管理>>权限维护
 </td>
 <td>

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
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/resources/skin/images/tbg.gif">&nbsp;权限列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	 <td>
     <div class="panel-body">
           <ul id="permissionTree" class="ztree"></ul>
	 </div>
    </td>
</tr>

</table>

</form>
  

</body>
</html>