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
    <script src="${pageContext.request.contextPath}/js/adminSelf.js"></script>
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
		adminSelf.updateSelf();
		adminSelf.updatePsw();
	});
</script>

</head>
<body>
<div class="modal fade" id="update-self" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改个人信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="update-form" method="post">
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updateadminName" id="updateadminName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">真实姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updatetrueName" id="updatetrueName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updatephone" id="updatephone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="coname" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updateemail" id="updateemail">
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
<div class="modal fade" id="update-psw" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改个人密码</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updatePsw-form" name="update-form" method="post">
                    <div class="form-group">
                        <label for="oldPsw" class="col-sm-2 control-label">旧密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="oldPsw" id="oldPsw">
                        </div>
                    </div>
                    <div class="form-group" style="display: none" id="oldPswError">
                        <label for="name" class="col-sm-2 control-label"></label>
                        <div class="col-sm-9">
                            <label style="color: #BD1F3B">请输入密码</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPsw" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="newPsw" id="newPsw">
                        </div>
                    </div>
                    <div class="form-group" style="display: none" id="newPswError">
                        <label for="name" class="col-sm-2 control-label"></label>
                        <div class="col-sm-9">
                            <label style="color: #BD1F3B">密码应长度大于6</label>
                        </div>
                    </div>
					<div class="form-group">
                        <label for="sameNewPsw" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="sameNewPsw" id="sameNewPsw">
                        </div>
                    </div>
                    <div class="form-group" style="display: none" id="sameNewPswError">
                        <label for="name" class="col-sm-2 control-label"></label>
                        <div class="col-sm-9">
                            <label style="color: #BD1F3B">两次密码不一致</label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveUpdatePsw" >保存</button>
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
                        <li>个人信息</li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget no-padding">
                <div class="tab-content">
                        <table class="table" cellpadding="6" cellspacing="1">
                            <thead>
                            <th style="border: 0px solid transparent">
                                <%--<h1>个人信息</h1>--%>
                            </th>
                            </thead>
                            <tbody >
                            <tr >
                                <th style="border: 0px solid transparent" class="tl">用户号</th>
                                <td style="border: 0px solid transparent" class="tr" id="adminIdVal">${admin.adminId}</td>
                            </tr>
                             <tr >
                                <th style="border: 0px solid transparent" class="tl">用户名</th>
                                <td style="border: 0px solid transparent" class="tr" id="adminNameVal">${admin.adminName}</td>
                            </tr>
                            <tr>
                                <th style="border: 0px solid transparent" class="tl">真实姓名</th>
                                <td style="border: 0px solid transparent" class="tr" id="trueNameVal">${admin.trueName}</td>
                            </tr>
                            <tr>
                                <th style="border: 0px solid transparent" class="tl">添加时间</th>
                                <td style="border: 0px solid transparent" class="tr" id="regTimeVal">
                                    ${admin.regTime.year+1900} 年
                                    ${admin.regTime.month+1} 月
                                    ${admin.regTime.date} 日
                                </td>
                            </tr>
                            <tr>
                                <th style="border: 0px solid transparent" class="tl">邮箱</th>
                                <td style="border: 0px solid transparent" class="tr" id="emailVal">${admin.email}</td>
                            </tr>
                            <tr>
                                <th style="border: 0px solid transparent" class="tl">手机号</th>
                                <td style="border: 0px solid transparent" class="tr" id="phoneVal">${admin.phone}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                <div class="mdl-card__actions mdl-card--border">
                    <button class="templatemo-blue-button" id="changeInfo"><h5>修改信息</h5></button>
                    <button class="templatemo-blue-button" id="changePsw"><h5>修改密码</h5></button>
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
