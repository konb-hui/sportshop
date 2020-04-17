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
    <script src="${pageContext.request.contextPath}/js/adminAllGoods.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script> 
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <style>
        .show-span {
            border: none !important;
        }
    </style>
</head>
<script type="text/javascript">
$().ready(function(){
    //设置分页要跳转到的url
	$("body").data("url","goodAction_listGood.action");
	//声明分页的事件
	SportShopUtils.basedata.initEvent();
	adminAllGoods.updateGood();
	adminAllGoods.addGood();
	adminAllGoods.deleteGood();
});
</script>
<body>
<div class="modal fade" id="update-good" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改商品</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="update-form" method="post">
                   <div class="form-group">
                        <label for="gid" class="col-sm-2 control-label">id</label>
                        <div class="col-sm-9">
                            <span id="updategid" class="form-control"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">商品名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updategname" id="updategname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updateprice" id="updateprice">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">vip价格</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="updatevipPrice" id="updatevipPrice">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-sm-2 control-label">类别</label>
                        <div class="col-sm-9">
                            <select id="updatecategory">
                            	<c:forEach items="${categories}" var="category">
                            		<option value="${category.cid}">${category.cname}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="brand" class="col-sm-2 control-label">品牌</label>
                        <div class="col-sm-9">
                             <select id="updatebrand">
                            	<c:forEach items="${brands}" var="brand">
                            		<option value="${brand.bid}">${brand.bname}</option>
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
<div class="modal fade" id="add-good" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="parentModal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">增加商品</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="add-form" name="add-form" method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">商品名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addgname" id="addgname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addprice" id="addprice">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">vip价格</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="addvipPrice" id="addvipPrice">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-sm-2 control-label">类别</label>
                        <div class="col-sm-9">
                            <select id="addcategory">
                            	<c:forEach items="${categories}" var="category">
                            		<option value="${category.cid}">${category.cname}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="brand" class="col-sm-2 control-label">品牌</label>
                        <div class="col-sm-9">
                             <select id="addbrand">
                            	<c:forEach items="${brands}" var="brand">
                            		<option value="${brand.bid}">${brand.bname}</option>
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
    <jsp:include page="sidebar.jsp"/>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <jsp:include page="goodsNav.jsp"/>
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget no-padding">
                <div class="panel panel-default table-responsive">
                    <table id="goodsinfo" class="table table-striped table-bordered templatemo-user-table">
                        <thead>
                        <tr>
                            <td><a href="" class="white-text templatemo-sort-by">id<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">商品名<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">价格<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">会员价格<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">品牌<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">类别<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">销售额<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">优惠券<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">颜色<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">尺寸<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">图片<span class="caret"></span></a></td>
                            <td>编辑</td>
                            <td>删除</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${good.rows}" var="goods" varStatus="num">
                            <tr>
                                <td id="gid">${goods.gid}</td>
                                <td id="gname">${goods.gname}</td>
                                <td id="price">${goods.price}</td>
                                <td id="vipPrice">${goods.vipPrice}</td>
                                <td id="gbrand">${goods.brand.bname}<input type="hidden" id="gbrandid" value="${goods.brand.bid}" /></td>
                                <td id="gcategory">${goods.category.cname}<input type="hidden" id="gcategoryid" value="${goods.category.cid}" /></td>
                                <td>${goods.salesvolume}</td>
                                <td><a href="discountAction_listDiscount?gid=${goods.gid}" class="templatemo-link">优惠券</a></td>
                                <td><a href="colorAction_listColor?gid=${goods.gid}" class="templatemo-link">颜色</a></td>
                                <td><a href="sizeAction_listSize?gid=${goods.gid}" class="templatemo-link">尺寸</a></td>
                                <td><a href="goodAction_listImages?gid=${goods.gid}" class="templatemo-link">图片</a></td>
                                <td><button class="templatemo-edit-btn" name="update">编辑</button></td>
                                <td><button class="templatemo-delete-btn" name="delete">删除</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="pagination-wrap" id="page-div-nav">
                <div class="page-info" id="page-info-area">
            </div>
        </div>
                                   <div class="col-md-5 page-info">
                       	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页" />&nbsp;<input type="button" flag="prePage" param="${good.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${good.currentPage+1}" flag="nextPage" last="${good.totalPages}" value="下一页" "/>&nbsp;<input type="button" param="${good.totalPages}" flag="lastPage" value="尾页" />&nbsp;<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${good.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" last="${good.totalPages}" id="jump" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${good.totalSize}条记录，当前第 ${good.currentPage}/${good.totalPages}页</p>
                    </div>
    </div>
    </div>
</div>
<div id="path" style="display: none;">${pageContext.request.contextPath}</div>

</body>
</html>
