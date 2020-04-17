<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <!--
    Visual Admin Template
    http://www.templatemo.com/preview/templatemo_455_visual_admin
    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/infostyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <script src="${pageContext.request.contextPath}/js/adminColor.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script> 
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    

<script type="text/javascript">
	$().ready(function(){
		adminColor.updateColor();
		adminColor.addColor();
		adminColor.deleteColor();
	});
</script>

</head>
<body>
<div class="modal fade" id="update-color" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改颜色</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="update-form" method="post">
                   <div class="form-group">
                        <label for="coid" class="col-sm-2 control-label">id</label>
                        <div class="col-sm-9">
                            <span id="updatecoid" class="form-control"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">颜色</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updateconame" id="updateconame">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveUpdate" >保存</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="add-color" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">增加颜色</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="add-form" name="add-form" method="post">
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">颜色</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addconame" id="addconame">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <input type="hidden" id="gid" value="${good.gid}">
                <button type="button" class="btn btn-primary" id="saveAdd" >保存</button>
            </div>
        </div>
    </div>
</div>
<!-- Left column -->
<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
            <div class="row">
                <nav class="templatemo-top-nav col-lg-12 col-md-12">
                    <ul class="text-uppercase">
                        <li><a href="goodAction_listGood" class="active">返回商品管理</a></li>
                    </ul>
                    <ul class="text-uppercase">
                        <li>${good.gname}</li>
                    </ul>
                    <ul class="text-uppercase">
                        <li><a href="#" class="active" id="add">添加颜色</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget no-padding">
                <div class="panel panel-default table-responsive">
                    <table id="goodsinfo" class="table table-striped table-bordered templatemo-user-table">
                        <thead>
                        <tr>
                            <td><a href="" class="white-text templatemo-sort-by">id<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">颜色<span class="caret"></span></a></td>
                            <td>删除</td>
                            <td>编辑</td>
                        </tr>
                        <c:forEach items="${colors}" var="color" varStatus="num">
                            <tr>
                                <td id="coid">${color.coid}</td>
                                <td id="coname">${color.coname}</td>
                                <td><button class="templatemo-delete-btn" name="delete">删除</button></td>
                                <td><button class="templatemo-delete-btn" name="update">编辑</button></td>
                            </tr>
                        </c:forEach>
                        </thead>
                    </table>
                </div>
            </div>

            <div class="pagination-wrap" id="page-div-nav">
                <div class="page-info" id="page-info-area">
                </div>
            </div>
        </div>
    </div>
</div>
<div id="path" style="display: none;">${pageContext.request.contextPath}</div>
<!-- JS -->
     <!-- Templatemo Script -->
</body>
</html>
