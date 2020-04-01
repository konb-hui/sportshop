
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 	<script>
            $(document).ready(function(){
                $(".list-group-item").hover(function(){
                    $(this).children("div.sort-detail").show();
                },function(){
                    $(this).children("div.sort-detail").hide();
                });
            })
        </script> -->
    <script>
        /*$(document).ready(function () {
            $(".data-item-li").children("div").addClass("to-big");
        });*/
    </script>
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
                                        <a href="${pageContext.request.contextPath}/category?cate=手机壳">跑步鞋</a> 
                                        <a href="${pageContext.request.contextPath}/category?cate=充电器">篮球鞋</a> 
                                        <a href="${pageContext.request.contextPath}/category?cate=充电器">休闲鞋</a> 
                                        <a href="${pageContext.request.contextPath}/category?cate=耳机">板鞋</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=镜头">帆布鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=单反">足球鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=胶片">拖鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=摄像">训练鞋</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">运动服饰
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=羽绒服">健身服</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=运动套装">运动套装</a> 
                                            <a href="">运动裤</a> 
                                            <a href="">卫衣</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=面膜">夹克风衣</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=口红">紧身衣</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=防嗮">棉服</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=香水">运动背心</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">运动配饰
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=四六级">运动袜子</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=充电器">运动包</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=听力">运动帽子</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">户外鞋服
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=连衣裙">冲锋衣</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=充电器"> 徒步鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate= T恤"> 抓绒衣裤</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=卫衣">羽绒服</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=外套">越野跑鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=衬衫">登山鞋</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=夹克">滑雪服</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=运动外套">军迷服饰</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">户外装备
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=腰带">背包</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=皮带">帐篷</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=帽子">户外帐篷</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=围巾">野餐用品</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=机械表">望远镜</a><a
                                            href="${pageContext.request.contextPath}/category?cate=石英表">智能手环</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=电子表">滑雪装备</a><a
                                            href="${pageContext.request.contextPath}/category?cate=石英表">冲浪滑雪</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">体育用品
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=Java">篮球</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=PHP">网球</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=C">台球</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=Python">排球</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=驾照">羽毛球拍</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=考研">乒乓球拍</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=计算机证书">网球拍</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=四六级">高尔夫</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                        <li class="list-group-item">垂钓游泳
                            <div class="sort-detail">
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=鱼竿">钓竿鱼线</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=钓箱钓椅">钓箱钓椅</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=浮漂鱼饵">浮漂鱼饵</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=钓鱼配件">钓鱼配件</a>
                                    </dd>
                                </dl>
                                <dl class="dl-hor">
                                    <dd>
                                        <a href="${pageContext.request.contextPath}/category?cate=餐盘">浮潜三宝</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=保温杯">泳镜</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=饭盒">游泳圈</a> <a
                                            href="${pageContext.request.contextPath}/category?cate=餐具套装">泳帽</a>
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

        <c:if test="${!empty digGoods}">
            <div class="module">
                <div class="hd">
                    <h2>数码</h2>
                    <hr>
                </div>

                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${digGoods}" var="goods">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.goodsid}"><img src="/shopimage/${goods.imagePaths[0].path}" alt=""
                                                        width="200" height="200"/>
                                        </a>
                                    </div>
                                    <p class="text-right">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.goodsid}">${goods.goodsname}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>￥${goods.price}</b>
                                    </div>
                                    <div>
                                        <c:if test="${goods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart btn btn-default"
                                                    data-id="${goods.goodsid}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <c:if test="${!goods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                    data-id="${goods.goodsid}"
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


