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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/infostyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <script src="${pageContext.request.contextPath}/js/adminAllOrder.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script> 
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <style>
        .head-div {
            font-size: 18px;
        }

        .goods-table thead {
            background-color: #fbffff;
        }

        .white-text {
            color: #404040;
        }
    </style>
</head>
<script type="text/javascript">
$().ready(function(){
    //设置分页要跳转到的url
	$("body").data("url","myorderAction_listCompletedOrder.action");
	map = new Map();
	//声明分页的事件
	SportShopUtils.basedata.initEvent();
});
</script>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"/>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <jsp:include page="adminOrderNav.jsp"/>
        <div class="templatemo-content-container">
            <%--<div class="templatemo-content-widget white-bg">--%>
            <%--<h2 class="margin-bottom-10">Geo Charts</h2>--%>
            <%--<p class="margin-bottom-0">Credit goes to <a href="http://jqvmap.com" target="_parent">JQVMap</a>.</p>--%>
            <%--</div>--%>

            <c:forEach items="${orders.rows}" var="order">
                <div class="templatemo-flex-row flex-content-row">
                    <div class="col-1">
                        <div class="panel panel-default margin-10">
                            <div class="panel-heading"><h2>${order.status}</h2></div>
                            <div class="panel-body">
                                <div>
                                    <div class="order-info margin-bottom-10">
                                        <div class="head-div">订单信息</div>
                                        <div>
                                            <table id="orderinfo" class="table table-striped table-bordered templatemo-user-table goods-table">
                                                <thead>
                                                <tr>
                                                    <td><a href="" class="white-text templatemo-sort-by">订单号<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">用户<span class="caret"></span></a>
                                                    </td>
                                                    <td><a href="" class="white-text templatemo-sort-by">原价<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">实付款<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">收货人<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">收货地址<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">联系方式<span
                                                            class="caret"></span></a></td>
                                                   <td><a href="" class="white-text templatemo-sort-by">物流<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">时间<span
                                                            class="caret"></span></a></td>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>${order.oid}</td>
                                                    <td>${order.user.uid}</td>
                                                    <td>￥${order.price}</td>
                                                    <td>￥${order.newprice}</td>
                                                    <td>${order.address.conname}</td>
                                                    <td>${order.address.province} ${order.address.city} ${order.address.county} ${order.address.detailaddr}</td>
                                                    <td>${order.address.contel}</td>
                                                    <td>${order.logistics.lname}</td>
                                                    <td>${order.time}</td>
                                                </tr>

                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                    <div class="goods-info margin-bottom-10">
                                        <div class="head-div">商品信息</div>
                                        <div>
                                            <table id="goodsinfo" class="table table-striped table-bordered templatemo-user-table goods-table">
                                                <thead>
                                                <tr>
                                                    <td><a href="" class="white-text templatemo-sort-by">商品id<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">商品名<span class="caret"></span></a>
                                                    </td>
                                                    <td><a href="" class="white-text templatemo-sort-by">价格<span
                                                            class="caret"></span></a></td>
                                                             <td><a href="" class="white-text templatemo-sort-by">vip价格<span
                                                            class="caret"></span></a></td>
                                                    <td><a href="" class="white-text templatemo-sort-by">数量<span
                                                            class="caret"></span></a></td>
                                                            <td><a href="" class="white-text templatemo-sort-by">颜色<span
                                                            class="caret"></span></a></td>
                                                            <td><a href="" class="white-text templatemo-sort-by">尺寸<span
                                                            class="caret"></span></a></td>
                                                        <%--<td><a href="" class="white-text templatemo-sort-by">类别<span--%>
                                                        <%--class="caret"></span></a></td>--%>
                                                    <td>详情</td>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${order.histories}" var="goods">
                                                    <tr>
                                                        <td>${goods.good.gid}</td>
                                                        <td>${goods.good.gname}</td>
                                                        <td>￥${goods.good.price}</td>
                                                        <td>￥${goods.good.vipPrice}</td>
                                                        <td>${goods.goodsnum}</td>
                                                        <td>${goods.shopcolor}</td>
                                                        <td>${goods.shopsize}</td>
                                                            <%--<td>234&lt;%&ndash;${goods.detailcate}&ndash;%&gt;</td>--%>
                                                        <td><a href="goodAction_showDetail/detail?gid=${goods.good.gid}" class="templatemo-link">详情</a></td>
                                                            <%--<td>
                                                                <button href="" class="templatemo-edit-btn">编辑</button>
                                                            </td>
                                                            <td>
                                                                <button href="" class="templatemo-delete-btn">删除</button>
                                                            </td>--%>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

                <div class="pagination-wrap" id="page-div-nav">
                    <div class="page-info" id="page-info-area">
                                                       
                    </div>
                </div>
                    <div class="col-md-5 page-info">
                       	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页" />&nbsp;<input type="button" flag="prePage" param="${orders.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${orders.currentPage+1}" flag="nextPage" last="${orders.totalPages}" value="下一页" "/>&nbsp;<input type="button" param="${orders.totalPages}" flag="lastPage" value="尾页" />&nbsp;<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${orders.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" last="${orders.totalPages}" id="jump" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${orders.totalSize}条记录，当前第 ${orders.currentPage}/${orders.totalPages}页</p>
                    </div>
        </div>
    </div>
</div>
</body>
</html>
