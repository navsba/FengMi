<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>商品类型</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<style>
    th {
        text-align: center;
    }

</style>
<script type="text/javascript">
    function showList(obj, id, name) {
        var jqobj = $(obj);
        $("#dropdownMenu2").html(jqobj.text() + "<span class='caret'></span>");
        $("#typeId").val(id);
    }

    function deleteConfirm(id, name) {

        Confirm.show('溫馨提示', '您确定要刪除[' + name + ']商品类型吗？', {
            '确定': {
                'primary': true,
                'callback': function () {
                    location.href = "${pageContext.request.contextPath}/goodstype/delete?id=" + id;
                }
            }
        });
    }

    function addGoodsType() {
        location.href = "${pageContext.request.contextPath}/goodstype/showadd";
    }

    function showEdit(id, name) {
        Confirm.show('溫馨提示', '您确定要修改[' + name + ']商品吗？', {
            '确定': {
                'primary': true,
                'callback': function () {
                    location.href = "${pageContext.request.contextPath}/goodstype/showEdit?id=" + id;
                }
            }
        });
    }
</script>
</head>
<body>
<nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/FengMi/after/goods_list.jsp">锋迷网管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/FengMi/after/goods_list.jsp">商品管理 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="">商品类型管理</a></li>
                <li><a href="/FengMi/after/user.jsp">用户管理</a></li>
                <li><a href="#">订单管理</a></li>
                <li><a href="../before/index.html">直通锋迷网</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#">${sessionScope.adminUserName}</a>
				</li>
				<li> <a href="/FengMi/after/login.jsp"><span class="glyphicon glyphicon-log-in" style="padding-left:0px"></span></a> </li>
				<li> <a href="/FengMi/after/login.jsp" style="padding-left:0px">退出</a> </li>

			</ul>
        </div>
    </div>
</nav>
<div class="jumbotron" style="padding-top:20px;padding-bottom:25px">
    <div class="container">
        <h2>商品类型</h2>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <button type="button" onclick="addGoodsType()" class="btn btn-info">添加商品分类</button>
        </div>
    </div>
</div>
<!--以下显示表格-->
<div class="container" style="margin-top:20px;">
    <form id="deleteFrom" action="${pageContext.request.contextPath}/goods/deleteBatch" method="post">
        <table style="text-align: center;margin-right:10px;width:99%"
               class="table table-striped table-hover table-bordered">
            <thead style="text-align: center;">
            <tr>
                <th>序号</th>
                <th>类型名称</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${sessionScope.goodsTypelist}" var="goodsType" varStatus="obj" >
				
	            <tr>
	                <td>${obj.count}</td>
	                <td>${goodsType.typename}</td>
	                <td><a><span class="glyphicon glyphicon-edit"
	                             color="#5BC0DE"
	                             onclick="showEdit(${goodsType.id},'${goodsType.typename}')"></span></a></td>
	                <td><a class="glyphicon glyphicon-trash" color="#5BC0DE"
	                       style="text-decoration:none"
	                       onclick="deleteConfirm(${goodsType.id},'${goodsType.typename}')"></a></td>
	
	            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>

