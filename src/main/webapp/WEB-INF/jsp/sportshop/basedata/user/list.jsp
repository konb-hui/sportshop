<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 蒋松冬
  Date: 2017/7/26
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>个人信息-我的订单</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/infostyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/list.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <script src="${pageContext.request.contextPath}/js/distpicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.raty.js"></script>
    <style>
        #view-source {
            position: fixed;
            display: block;
            right: 0;
            bottom: 0;
            margin-right: 40px;
            margin-bottom: 40px;
            z-index: 900;
        }

        .templatemo-blue-button {
            background-color: #39ADB4;
            border: none;
            color: white;
        }

        .no-border{border: 0px solid transparent !important;}

        .bs-example {
            position: relative;
            padding: 45px 15px 15px;
            margin: 0 -15px 15px;
            border-color: #e5e5e5 #eee #eee;
            border-style: solid;
            border-width: 1px 0;
            -webkit-box-shadow: inset 0 3px 6px rgba(0,0,0,.05);
            box-shadow: inset 0 3px 6px rgba(0,0,0,.05);
        }

        .finish-btn{
            background-color:#e65b0e !important;
        }

        .font-color{
            color: #00BBD6; !important;
        }


    </style>
</head>
<body>
<div class="modal fade" id="pay" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPsw">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabelPsw">支付界面</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updatePsw-form" name="update-form" method="post">
                    <div class="form-group">
                        <label for="star" class="col-sm-2 control-label">支付方式</label>
                        <div class="col-sm-9">
                            <select class="form-control">
                            	<option>微信</option>
                            	<option>支付宝</option>
                            	<option>银联</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="star" class="col-sm-2 control-label">需支付：</label>
                        <div class="col-sm-9">
                           <span id="paymoney" class="form-control"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="savePay" >支付</button>
            </div>
        </div>
    </div>
</div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">订单管理</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder">未付款</a></span>&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder2">未发货</a></span>&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder3">已发货</a></span>&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder4">已完成</a></span>&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder5">退款中</a></span>&nbsp;&nbsp;&nbsp;
            <span class="mdl-layout-title"><a href="myorderAction_listOrder6">退款成功</a></span>
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <%-- <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                     <i class="material-icons">search</i>
                 </label>
                 <div class="mdl-textfield__expandable-holder">
                     <input class="mdl-textfield__input" type="text" id="search">
                     <label class="mdl-textfield__label" for="search">Enter your query...</label>
                 </div>--%>
            </div>
            <%-- <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                 <i class="material-icons">more_vert</i>
             </button>
             <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                 <li class="mdl-menu__item">About</li>
                 <li class="mdl-menu__item">Contact</li>
                 <li class="mdl-menu__item">Legal information</li>
             </ul>--%>
        </div>
    </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
            <div class="demo-avatar-dropdown">
                <h1>体育商城</h1>
                <div class="mdl-layout-spacer"></div>
            </div>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/main.jsp"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">home</i>主页</a>
            <a class="mdl-navigation__link" href="userAction_information"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">inbox</i>个人信息</a>
            <a class="mdl-navigation__link" href="myorderAction_listOrder"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">forum</i>订单管理</a>
            <a class="mdl-navigation__link" href="userAction_address"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">local_offer</i>地址管理</a>
            <a class="mdl-navigation__link" href="userAction_listFavorite"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">flag</i>我的收藏</a>
        </nav>
    </div>
    <main class="mdl-layout__content mdl-color--grey-100">
            <div class="mdl-grid demo-content" id="parent">
                <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                    <h3>未付款</h3><%--未收到货--%>
                    <c:forEach items="${orderList}" var="order">
                        <c:if test="${order.status eq '未付款'}">
                            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid" name="parent">
                            <div class="tab-content col-lg-12">
                                <table class="table " cellpadding="6" cellspacing="1" ><%--订单信息--%>
                                    <tbody>
                                    <td class="no-border col-lg-9" >
                                        订单号：<i name="oid">${order.oid}</i>
                                        &nbsp;
                                        &nbsp;
                                        订单日期:
                                            ${order.time.year+1900} 年
                                            ${order.time.month+1} 月
                                            ${order.time.date} 日
                                        &nbsp;
                                        收货地址:
                                            ${order.address}
                                         
                                    </td>
                                     <td  class="no-border col-lg-3">
                                        收货人: ${order.consignee}
                                        <tr>
                                    <td  class="no-border col-lg-3">
                                        原价:${order.price}&nbsp;&nbsp;&nbsp;实付款:${order.newprice}
                                    </td>
                                    <td  class="no-border col-lg-3">
                                                       联系电话：${order.phone}
                                    </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="table " cellpadding="6" cellspacing="1" ><%--商品描述--%>
                                    <tbody>
                                    <tr>
                                        <td class="col-lg-1">
                                            商品号
                                        </td>
                                        <td class="col-lg-2">
                                            商品名称
                                        </td>
                                        <td class="col-lg-1">
				  颜色						</td>
                                        <td class="col-lg-1">
                               尺寸						</td>
                                        <td class="col-lg-1">
                                            普通/会员价格
                                        </td>
                                        <td class="col-lg-1">
                                            数量
                                        </td>
                                        <td class="col-lg-2">
                                            商品分类
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            <c:forEach items="${order.histories}" var="good">
                                    <table class="table table-bordered" cellpadding="6" cellspacing="1" ><%--商品信息--%>

                                        <tbody>
                                        <tr>
                                            <td class="col-lg-1">
                                                    ${good.good.gid}
                                            </td>
                                            <td class="col-lg-2">
                                                <a href="goodAction_showDetail?gid=${good.good.gid}">${good.good.gname}</a>
                                            </td>
                                             <td class="col-lg-1">
                                                    ${good.shopcolor}
                                            </td>
                                            <td class="col-lg-1">
                                                    ${good.shopsize}
                                            </td>
                                            <td class="col-lg-1">
                                                    ${good.good.price}/${good.good.vipPrice}
                                            </td>
                                            <td class="col-lg-1">
                                                    ${good.goodsnum}
                                            </td>
                                            <td class="col-lg-2">
                                                    ${good.good.category.cname}
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                            </c:forEach>
                                 <div class="mdl-card__actions mdl-card--border">
                                    <button class="templatemo-blue-button" name="pay"><h5>继续付款</h5></button>
                                    <button class="templatemo-blue-button finish-btn" name="deleteList"><h5>取消订单</h5></button>
                                    <input type="hidden" id="oid" value="${order.oid}">	
                                    <input type="hidden" id="money" value="${order.newprice}">	
                                </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </div>
                </div>
                </main>
<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>
