<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/sportshop/common/common.jsp"%>
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
    <script src="${pageContext.request.contextPath}/js/adminManage.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script> 
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    

<script type="text/javascript">
	$().ready(function(){
		//设置分页要跳转到的url
		$("body").data("url","userAction_userManage.action");
		//声明分页的事件
		SportShopUtils.basedata.initEvent();
		adminManage.updateAdmin();
		adminManage.addAdmin();
		adminManage.deleteAdmin();
	});
</script>

</head>
<body>
<div class="modal fade" id="update-admin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改管理员</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="update-form" method="post">
                   <div class="form-group">
                        <label for="adminId" class="col-sm-2 control-label">id</label>
                        <div class="col-sm-9">
                            <span id="updateadminId" class="form-control"></span>
                        </div>
                    </div>s
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">角色</label>
                        <div class="col-sm-9">
                            <select id="updaterole" name="updaterole">
                            	<c:forEach items="${roles}" var="role">
                            		<option value="${role.rid}">${role.rname}</option>
                            	</c:forEach>
                            </select>
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
<div class="modal fade" id="add-admin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="add-form" method="post">
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addadminName" id="addadminName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addpassword" id="addpassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addphone" id="addphone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-9">
                            <select name="addsex" id="addsex">
                            	<option value="男">男</option>
                            	<option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">真实姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addtrueName" id="addtrueName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addemail" id="addemail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">角色</label>
                        <div class="col-sm-9">
                            <select id="addrole" name="addrole">
                            	<c:forEach items="${roles}" var="role">
                            		<option value="${role.rid}">${role.rname}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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
                        <li><a href="#" class="active" id="add">添加管理员</a></li>
                    </ul>
                    <ul class="text-uppercase">
                        <li><a href="roleAction_listRole" class="active">管理角色</a></li>
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
                            <td><a href="" class="white-text templatemo-sort-by">用户名<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">电话<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">性别<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">真实姓名<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">邮箱<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">角色<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">添加时间<span class="caret"></span></a></td>
                            <td>查看操作日志</td>
                            <td>删除</td>
                            <td>编辑</td>
                        </tr>
                        <c:forEach items="${admins.rows}" var="admin" varStatus="num">
                            <tr>
                                <td id="adminId">${admin.adminId}</td>
                                <td id="adminName">${admin.adminName}</td>
                                <td id="phone">${admin.phone}</td>
                                <td id="sex">${admin.sex}</td>
                                <td id="trueName">${admin.trueName}</td>
                                <td id="email">${admin.email}</td>
                                <td id="role">${admin.role.rname}</td>
                                <td id="regTime">${admin.regTime}</td>
                                <td><a href="infoAction_listInfo?adminId=${admin.adminId}" class="templatemo-link">查看操作日志</a></td>
                                <td><button class="templatemo-delete-btn" name="delete">删除</button></td>
                                <td><button class="templatemo-delete-btn" name="update">修改角色</button>
                                	<input type="hidden" id="adminRid" value="${admin.role.rid}">
                                </td>
                            </tr>
                        </c:forEach>
                        </thead>
                    </table>
                </div>
            </div>

<div class="col-md-5 page-info">
                       	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页" />&nbsp;<input type="button" flag="prePage" param="${admins.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${admins.currentPage+1}" flag="nextPage" last="${admins.totalPages}" value="下一页" "/>&nbsp;<input type="button" param="${admins.totalPages}" flag="lastPage" value="尾页" />&nbsp;<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${admins.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" last="${admins.totalPages}" id="jump" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${admins.totalSize}条记录，当前第 ${admins.currentPage}/${admins.totalPages}页</p>
                    </div>
        </div>
    </div>
</div>
<div id="path" style="display: none;">${pageContext.request.contextPath}</div>
<!-- JS -->
     <!-- Templatemo Script -->
</body>
</html>
