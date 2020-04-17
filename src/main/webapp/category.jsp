
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/sportshop/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>淘一淘类别</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
    <style>
        .like-button {
            left: 80% !important;
            top: 70% !important;
        }
        .data>ul {
            padding: 0;
        }
        .page-div {
            margin-top: 10px;
        }
        .page-info {
            padding: 35px 35px 35px 55px;
        }
    </style>
</head>
<script type="text/javascript">
	$().ready(function(){
	    //设置分页要跳转到的url
		$("body").data("url","goodAction_findGoodByCid.action");
		//声明分页的事件
		SportShopUtils.basedata.initEvent();
	});
</script>
<body>
<div id="main" class="container">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>
    <div class="content">
        <div class="module">
            <div class="">
                <h3>
                    类别><span style="color: red;">${cate}</span>
                </h3>
                <hr>
            </div>

            <div class="bd">
                <div class="data">
                    <ul>
                        <c:forEach items="${goods.rows}" var="good">
                            <li class="data-item-li">
                                <div class="to-big">
                                    <a href="goodAction_showDetail?gid=${good.gid}"> <img src="${pageContext.request.contextPath}/${good.images}/1.jpg" width="260px" height="260px" alt=""/>
                                    </a>
                                </div>
                                <p class="text-right">
                                    <a href="goodAction_showDetail/detail?gid=${good.gid}">${good.gname}</a>
                                </p>
                                <div class="text-right">
                                	<b>普通价：￥${good.price}</b>
                                    <b>VIP价：￥${good.vipPrice}</b>
                                </div>
                                <div>
 
                                    <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                </div>
                            </li>
                        </c:forEach>

                        <div class="clear-float" style="clear: both;"></div>
                    </ul>
                </div>
                <div class="row page-div">
                    <div class="col-md-5 page-info">
                       	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;<input type="button" flag="prePage" param="${goods.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${goods.currentPage+1}" flag="nextPage" last="${goods.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${goods.totalPages}" flag="lastPage" value="尾页"/>&nbsp;<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${goods.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" id="jump" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${goods.totalSize}条记录，当前第 ${goods.currentPage}/${goods.totalPages}页</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

