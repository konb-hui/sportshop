<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>体育商城</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
</head>
<body>
<div id="main" class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
 
        <!-- 旋转图 -->
        <div class="header-bottom">
            <div class="sort">
                <div class="sort-channel">
                    <ul class="sort-channel-list list-group">
                        <li class="list-group-item">运动鞋
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=1">跑步鞋</a> 
                                        <a href="goodAction_findGoodByCid?cid=2">篮球鞋</a> 
                                        <a href="goodAction_findGoodByCid?cid=3">休闲鞋</a> 
                                        <a href="goodAction_findGoodByCid?cid=4">板鞋</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=5">帆布鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=6">足球鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=7">拖鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=8">训练鞋</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">运动服饰
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=9">健身服</a> <a
                                            href="goodAction_findGoodByCid?cid=10">运动套装</a> 
                                            <a href="goodAction_findGoodByCid?cid=11">运动裤</a> 
                                            <a href="goodAction_findGoodByCid?cid=12">卫衣</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=13">夹克风衣</a> <a
                                            href="goodAction_findGoodByCid?cid=14">紧身衣</a> <a
                                            href="goodAction_findGoodByCid?cid=15">棉服</a> <a
                                            href="goodAction_findGoodByCid?cid=16">运动背心</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">运动配饰
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=17">运动袜子</a> <a
                                            href="goodAction_findGoodByCid?cid=18">运动包</a> <a
                                            href="goodAction_findGoodByCid?cid=19">运动帽子</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">户外鞋服
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=20">冲锋衣</a> <a
                                            href="goodAction_findGoodByCid?cid=21"> 徒步鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=22"> 抓绒衣裤</a> <a
                                            href="goodAction_findGoodByCid?cid=23">羽绒服</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=24">越野跑鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=25">登山鞋</a> <a
                                            href="goodAction_findGoodByCid?cid=26">滑雪服</a> <a
                                            href="goodAction_findGoodByCid?cid=27">军迷服饰</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">户外装备
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=28">背包</a> <a
                                            href="goodAction_findGoodByCid?cid=29">帐篷</a> <a
                                            href="goodAction_findGoodByCid?cid=30">户外帐篷</a> <a
                                            href="goodAction_findGoodByCid?cid=31">野餐用品</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=32">望远镜</a><a
                                            href="goodAction_findGoodByCid?cid=33">智能手环</a> <a
                                            href="goodAction_findGoodByCid?cid=34">滑雪装备</a><a
                                            href="goodAction_findGoodByCid?cid=35">冲浪滑雪</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">体育用品
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=36">篮球</a> <a
                                            href="goodAction_findGoodByCid?cid=37">网球</a> <a
                                            href="goodAction_findGoodByCid?cid=38">台球</a> <a
                                            href="goodAction_findGoodByCid?cid=39">排球</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=40">羽毛球拍</a> <a
                                            href="goodAction_findGoodByCid?cid=41">乒乓球拍</a> <a
                                            href="goodAction_findGoodByCid?cid=42">网球拍</a> <a
                                            href="goodAction_findGoodByCid?cid=43">高尔夫</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">垂钓游泳
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=44">钓竿鱼线</a> <a
                                            href="goodAction_findGoodByCid?cid=45">钓箱钓椅</a> <a
                                            href="goodAction_findGoodByCid?cid=46">浮漂鱼饵</a> <a
                                            href="goodAction_findGoodByCid?cid=47">钓鱼配件</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="goodAction_findGoodByCid?cid=49">浮潜三宝</a> <a
                                            href="goodAction_findGoodByCid?cid=50">泳镜</a> <a
                                            href="goodAction_findGoodByCid?cid=51">游泳圈</a> <a
                                            href="goodAction_findGoodByCid?cid=52">泳帽</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/image/4.jpg" alt="">
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/3.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/5.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/6.jpg" alt="">
                    </div>
                </div>

                <ol class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                    <li data-target="#mycarousel" data-slide-to="3"></li>
                </ol>

                <a class="left carousel-control" href="#mycarousel" role="button"
                   data-slide="prev" style="display: none;"> <span
                        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#mycarousel" role="button"
                        data-slide="next" style="display: none;"> <span
                    class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
            <div class="clear-float"></div>
        </div>
    </div>
    <div class="content">

        <c:if test="${!empty newGoods}">
            <div class="module">
                <div class="hd">
                    <h2>新品</h2>
                    <hr>
                </div>

                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${newGoods}" var="goods" varStatus="vs">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="goodAction_showDetail?gid=${goods.gid}"><img src="${pageContext.request.contextPath}/${goods.images}/1.jpg" alt=""
                                                        width="250" height="250"/>
                                        </a>
                                    </div>
                                    <p>
                                        <a  href="goodAction_showDetail?gid=${goods.gid}" style="font-size:15px">${fn:substring(goods.gname,0,18)}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>普通价：￥${goods.price}</b>
                                    <b>VIP价：￥${goods.vipPrice}</b>
                                    </div>
                                </li>
                            </c:forEach>


                            <div class="clear-float" style="clear: both;"></div>
                        </ul>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${!empty houseGoods}">
            <div class="module">
                <div class="hd">
                    <h2>家电</h2>
                    <hr>
                </div>

                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${houseGoods}" var="housegoods">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${housegoods.goodsid}"> <img
                                                src="/shopimage/${housegoods.imagePaths[0].path}" alt=""
                                                width="200" height="200">
                                        </a>
                                    </div>
                                    <p class="text-right">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${housegoods.goodsid}">${housegoods.goodsname}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>￥${housegoods.price}</b>
                                    </div>
                                    <div>
                                        <c:if test="${housegoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart btn btn-default"
                                                    data-id="${housegoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <c:if test="${!housegoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                    data-id="${housegoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                    </div>
                                </li>
                            </c:forEach>

                            <div class="clear-float" style="clear: both;"></div>
                        </ul>

                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${!empty colGoods}">
            <div class="module">
                <div class="hd">
                    <h2>服饰</h2>
                    <hr>
                </div>

                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${colGoods}" var="colgoods">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${colgoods.goodsid}"> <img
                                                src="/shopimage/${colgoods.imagePaths[0].path}" alt=""
                                                width="200" height="200">
                                        </a>
                                    </div>
                                    <p class="text-right">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${colgoods.goodsid}">${colgoods.goodsname}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>￥${colgoods.price}</b>
                                    </div>
                                    <div>
                                        <c:if test="${colgoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart btn btn-default"
                                                    data-id="${colgoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <c:if test="${!colgoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                    data-id="${colgoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                    </div>
                                </li>
                            </c:forEach>

                            <div class="clear-float" style="clear: both;"></div>
                        </ul>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${!empty bookGoods}">
            <div class="module">
                <div class="hd">
                    <h2>书籍</h2>
                    <hr>
                </div>

                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${bookGoods}" var="bookgoods">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${bookgoods.goodsid}"> <img
                                                src="/shopimage/${bookgoods.imagePaths[0].path}" alt=""
                                                width="200" height="200">
                                        </a>
                                    </div>
                                    <p class="text-right">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${bookgoods.goodsid}">${bookgoods.goodsname}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>￥${bookgoods.price}</b>
                                    </div>
                                    <div>
                                        <c:if test="${bookgoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart btn btn-default"
                                                    data-id="${bookgoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <c:if test="${!bookgoods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                    data-id="${bookgoods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                    </div>
                                </li>
                            </c:forEach>

                            <div class="clear-float" style="clear: both;"></div>
                        </ul>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>


