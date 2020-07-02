<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<script src="${pageContext.request.contextPath}/js/chat.js"></script>
<div class="row">
    <div class="col-md-4" role="navigation">

        <ul class="nav nav-pills">
            <c:if test="${empty sessionScope.user}">
                <li><a href="loginAction_login" style="color: #F22E00">请登录</a></li>
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                <li class="info-a">
                    <a href="userAction_information" style="color: #F22E00">
                        ${sessionScope.user.username}
                    <span class="glyphicon glyphicon-triangle-bottom" style="font-size: 5px;margin-left: 7px;" aria-hidden="true">
                    </span>
                    </a>
                    <input type="hidden" id="chatUid" value="${sessionScope.user.uid}">
                    <ul class="dropdown-menu">
                        <li><a href="userAction_information">账户管理</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="loginAction_logout" class="login-out">退出登录</a></li>
                    </ul>
                </li>
            </c:if>
			<c:if test="${empty sessionScope.user}">
                <li><a href="registerAction_register">注册</a></li>
            </c:if>
            
        </ul>
    </div>
    <script type="text/javascript">
    function jumpchat(obj) {
    	$.ajax({
	        url: "chatAction_resetChatNum",
	        type: "post",
	        data: {},
	     success: function(){
	    	 window.location.href = "chatAction_chatCustomerService";
	     },
	     error:function (){
	         alert("连接失败");
	     }
	 });	
	}
    </script>
    <div class="col-md-8">
        <ul class="nav nav-pills pull-right">
            <li><a href="userAction_VIP"> <i
                    class="fa fa-comment"></i>会员
            </a></li>
            <li><a href="javascript:void(0)" id="message" value="${sessionScope.chatnum}" onclick="jumpchat(this)"></a></li>
            <li><a href="shopCartAction_goCart"> <i
                    class="fa fa-shopping-cart" style="color: #F22E00"></i>
                购物车
            </a></li>
            <li><a href="userAction_listFavorite"> <i
                    class="fa fa-star"></i> 收藏夹
            </a></li>
        </ul>
    </div>
</div>
<div id="header-nav">
    <nav class="navbar navbar-default" id="header-nav-middle">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/main.jsp"><!-- <img alt="Brand" style="display: inline-block;" src="./image/tao.jpg" width="20" height="20"> --><span class="logo-word">体育商城</span></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a class="a-color" href="${pageContext.request.contextPath}/main.jsp">首页</a></li>
                    <li><a class="a-color" href="userAction_information">个人信息</a></li>
                    <li class="dropdown"><a class="a-color" href="myorderAction_listOrder"
                                            class="dropdown-toggle" data-toggle="dropdown" role="button"
                                            aria-haspopup="true" aria-expanded="false">我的订单 <span
                            class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="userAction_address">地址管理</a></li>
                            <li><a href="myorderAction_listOrder">交易中</a></li>
                        </ul></li>
                </ul>

                <form class="navbar-form navbar-right" role="search" method="get" action="goodAction_searchGood">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="keyword">
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search" aria-label="搜索"></span>
                    </button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>