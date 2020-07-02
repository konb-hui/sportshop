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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    

<script type="text/javascript">
	$().ready(function(){
	    //设置分页要跳转到的url
	    map = new Map();
	    if($("#sex").val().trim()!=""){
	    	map.set("sex",$("#sex").val());
	    }
	    if($("#key").val().trim()!=""){
	    	map.set("key",$("#key").val())
	    }
	    
	    $("body").data("url","userAction_userManage");
		//声明分页的事件
		SportShopUtils.basedata.initEvent();
		UserManage.changeSex();
		UserManage.searchForName();
	});
	function deleteByUid(obj) {
		var uid = $(obj).val();
		if(window.confirm("您确认要删除吗?")){
		    $.ajax({
		        url: "userAction_deleteByUid",
		        type: "post",
		        data: {
		        	uid:uid
		        },
		        success: function (result) {
					location.reload();
		        },
		        error: function (result) {
		            swal("删除失败");
		        }
		    });
		}else{
			return false;//如果返回的是false,则表单不提交
		}
	}
</script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">

</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
            <div class="row">
                <nav class="templatemo-top-nav col-lg-12 col-md-12">
                    <ul class="text-uppercase">
                        <li><a href="userAction_userManage" class="active">所有用户</a></li>
                    </ul>
                    <span>&nbsp;</span>
                    <select name="sex" id="sex">
                    	<option value="1">选择性别</option>
                    	<option value="男" ${sex == "男" ?"selected":"" }>男</option>
                    	<option value="女" ${sex == "女" ?"selected":"" }>女</option>
                    </select>
                    <span>&nbsp;</span>
                    <input type="text" placeholder="输入用户名查找" id="key" name="key" value="${key}">
                    <span>&nbsp;</span>
                    <button class="btn btn-default" id="search">
                        <span>搜索</span>
                    </button>
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
                            <td><a href="" class="white-text templatemo-sort-by">账户<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">用户名<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">性别<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">会员状态<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">Email<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">联系电话<span class="caret"></span></a></td>
                            <td>删除</td>
                        </tr>
                        </thead>
                        <c:forEach items="${users.rows}" var="user" varStatus="num">
                            <tr>
                                <td id="uid">${user.uid}</td>
                                <td>${user.account}</td>
                                <td>${user.username}</td>
                                <td>${user.sex}</td>
                                <td>${user.isvip}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td><button class="templatemo-delete-btn" onclick="deleteByUid(this)" value="${user.uid}">删除</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="pagination-wrap" id="page-div-nav">
                <div class="page-info" id="page-info-area">
                </div>
            </div>
        </div>
                           <div class="col-md-5 page-info">
                       	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页" />&nbsp;<input type="button" flag="prePage" param="${users.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${users.currentPage+1}" flag="nextPage" last="${users.totalPages}" value="下一页" "/>&nbsp;<input type="button" param="${users.totalPages}" flag="lastPage" value="尾页" />&nbsp;<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${users.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" last="${users.totalPages}" id="jump" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${users.totalSize}条记录，当前第 ${users.currentPage}/${users.totalPages}页</p>
                    </div>
    </div>
</div>
<div id="path" style="display: none;">${pageContext.request.contextPath}</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/userManage.js"></script>     <!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
</body>
</html>
