<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/skin/js/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ztree/zTreeStyle.css">
    <script src="${pageContext.request.contextPath}/resources/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script>
        var setting = {
            check: {
                enable: true
            }
        };
        var zNodes={
            name:"OA办公系统",
            open:true,
            children:[
                {
                    name:"客户关系管理",
                    open:false
                },
                {
                    name:"项目管理",
                    open:false,
                    children:[
                        {
                            name:"需求分析",
                            open:false,
                        },
                        {
                            name:"模块管理",
                            open:false,
                        },
                        {
                            name:"功能管理",
                            open:false,
                        }
                    ]
                },
                {
                    name:"日常办公管理",
                    open:false
                }
            ]
        };
        $(function () {
            $.fn.zTree.init($("#tt"),setting,zNodes);
        });
    </script>

</head>
<body>
    <ul id="tt" class="ztree"></ul>
</body>
</html>
