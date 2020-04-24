
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html class="" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>淘一淘-商品详情</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- all css here -->
    <!-- bootstrap v3.3.6 css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <link href="${pageContext.request.contextPath}/css/shopdetail.css" rel="stylesheet">
    <!-- <script src="./detail/js/jquery.js"></script> -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <%--<script src="${pageContext.request.contextPath}/js/sort.js"></script>--%>

    <!-- bootstrap js -->
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/detail.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
        	var flag1 = 0;
        	var flag2 = 0;
			  $("#color").children().click(function(){
				  $(this).attr("class","btn btn-default btn-lg active");
				  $(this).siblings().attr("class","btn btn-default btn-lg");
				  $('#shopcolor').val($(this).val());
				  flag1 = 1;
				});
			  $("#size").children().click(function(){
				  $(this).attr("class","btn btn-default btn-lg active");
				  $(this).siblings().attr("class","btn btn-default btn-lg");
				  $('#shopsize').val($(this).val());
				  flag2 = 1;
				});
			  $("#gotoorder").click(function(){
				  window.location.href="shopCartAction_goCart";
			  });
			  $("#buy").click(function(){
				  if(flag1 == 0 || flag2 == 0){
					  alert("请选择颜色和尺码");
				  }else{
					  var shopcolor = $('#shopcolor').val();
					  var shopsize = $('#shopsize').val();
					  var gid = $('#gid').val();
					  var goodsnum = $('#goodsnum').val();
	                  $.ajax({
	                      url:"shopCartAction_addBuy",
	                      type:"POST",
	                      data:{
	                          gid:gid,
	                          shopcolor:shopcolor,
	                          shopsize:shopsize,
	                          goodsnum:goodsnum,
	                      },
	                      success:function (result) {
	                    	  window.location.href="shopCartAction_confirmBuy";
	                      },
	                      error:function () {
	                          alert("添加失败");
	                      }
	                  });
				  }
			  });
			  $("#addCart").click(function(){
				  if(flag1 == 0 || flag2 == 0){
					  alert("请选择颜色和尺码");
				  }else{
					  var shopcolor = $('#shopcolor').val();
					  var shopsize = $('#shopsize').val();
					  var gid = $('#gid').val();
					  var goodsnum = $('#goodsnum').val();
	                  $.ajax({
	                      url:"shopCartAction_addCart",
	                      type:"POST",
	                      data:{
	                          gid:gid,
	                          shopcolor:shopcolor,
	                          shopsize:shopsize,
	                          goodsnum:goodsnum,
	                      },
	                      success:function (result) {
	                          //收藏成功
								if(result == "请登录"){
									window.location.href="loginAction_login";
								}else{
									$("#cart-jump").modal({
							            backdrop:'static'
							        });
								}
	                      },
	                      error:function () {
	                          alert("添加失败");
	                      }
	                  });
				  }
			  });
			  $(".span-block").children().click(function(){
					var did = $(this).val();
                  $.ajax({
                      url:"./userAction_addDiscount",
                      type:"POST",
                      data:{
						did:did
                      },
                      success:function (result) {
                          //收藏成功
							if(result == "领取失败") alert("您已经领取了该优惠券！");
							else alert("领取成功！");
                      },
                      error:function () {
                          alert("添加失败");
                      }
                  });
			  });
            var showproduct = {
                "boxid": "showbox",
                "sumid": "showsum",
                "boxw": 400,
                "boxh": 550,
                "sumw": 60, //列表每个宽度,该版本中请把宽高填写成一样
                "sumh": 60, //列表每个高度,该版本中请把宽高填写成一样
                "sumi": 7, //列表间隔
                "sums": 5, //列表显示个数
                "sumsel": "sel",
                "sumborder": 1, //列表边框，没有边框填写0，边框在css中修改
                "lastid": "showlast",
                "nextid": "shownext"
            }; //参数定义
            $.ljsGlasses.pcGlasses(showproduct); //方法调用，务必在加载完后执行

            $(function () {

                $('.tabs a').click(function () {

                    var $this = $(this);
                    $('.panel').hide();
                    $('.tabs a.active').removeClass('active');
                    $this.addClass('active').blur();
                    var panel = $this.attr("href");
                    $(panel).show();
                    return fasle; //告诉浏览器  不要指向这个链接
                }); //end click


                $(".tabs li:first a").click(); //web 浏览器，单击第一个标签吧

            }); //end ready

            $(".centerbox li").click(function () {
                $("li").removeClass("now");
                $(this).addClass("now");

            });
            $('.fav-button').click(function(){
                //$(this).removeClass("glyphicon-heart-empty");
                var goodsId = $(this).attr('data-id');
                if($('#favorite').text()=="收藏") {
                    //收藏
                    $.ajax({
                        url:"./goodAction_addFavorite",
                        type:"POST",
                        data:{
                            gid:goodsId
                        },
                        success:function (result) {
                            //收藏成功
                            if(result == "未登陆"){
                                location.href = "./loginAction_login";
                            }else{
                            	$('#favorite').text("取消收藏");
                            	isChangeBtn = true;
                            }
                        },
                        error:function () {
                            alert("收藏失败");
                        }
                    })
                } else {
                    //取消收藏
                    $.ajax({
                        url:"./goodAction_deleteFavorite",
                        type:"POST",
                        data:{
                            gid:goodsId
                        },
                        success:function (result) {
                            //取消收藏成功
                        	$('#favorite').text("收藏");
                        },
                        error:function () {
                            alert("取消收藏失败");
                        }
                    })
                }

                /*$.post("servlet/CollectServlet", {
                 goodsId: goodsId,
                 });
                 // alert("商品已加入购物车！");*/

            });
        });
    </script>
    <style>
        .head{
            width: 45px !important;
            background: rgba(0,0,0,.0001) none repeat scroll 0 0 !important;
            border: 1px solid rgba(0,0,0,.075) !important;
        }
        .span-block{
            display: block !important;
            padding:5px;
        }
    </style>

</head>

<body>
<div class="modal fade" id="cart-jump" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
				<span>添加成功!</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">继续购物</button>
                <button type="button" class="btn btn-primary" id="gotoorder" >去购物车</button>
            </div>
        </div>
    </div>
</div>
<!--zoom elavator area one start-->
<div class="elavator_area">
    <div class="container">
        <jsp:include page="header.jsp"/>
        <div class="shop_menu shop_menu_2 main-detail-div">
            <ul class="cramb_area cramb_area_5 main-detail-nav">
                <li><a href="index.html">首页 /</a></li>
                <%--<li><a href="index.html">Shop /</a></li>
                <li><a href="index.html">Headlight/</a></li>
                <li><a href="index.html">Hats /</a></li>--%>
                <li class="br-active">${good.gname}</li>
            </ul>
        </div>
        <div class="row">
            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                <div class="shopdetails">
                    <div id="leftbox">
                        <div id="showbox">
                            <c:forEach items="${images}" var="path">
                                <img src="${pageContext.request.contextPath}/${path}" width="400" height="400"/>
                            </c:forEach>
                        </div>
                        <div id="showsum">
                        </div>
                        <p class="showpage">
                            <a href="javascript:void(0);" id="showlast"> < </a>
                            <a href="javascript:void(0);" id="shownext"> > </a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="elav_titel">
                    <div class="elv_heading">
                        <h3>${good.gname}</h3>
                    </div>
                </div>
                <div class="elav_info">
                    <!-- 价格 -->
                    <div class="price_box price_box_acr new_meta">
                        <%--<span class="old- price old- price-2">$250.00</span>--%>
                        <span class="spical-price spical-price-2">普通价：￥${good.price}</span>
                        <span class="spical-price spical-price-2">会员价：￥${good.vipPrice}</span>
                    </div>
                    <div class="new_meta">
                            <span class="sku_wrapper big-font" id="color">
                                颜色:
                                <c:forEach var="color" items="${good.colors}" varStatus="status">
    							<c:if test="${status.index % 4 == 0}">
        						<br /> <!-- 是表格就加个<tr></tr> -->
    							</c:if>
    							<button value="${color.coname}" class="btn btn-default btn-lg">${color.coname}</button>
								</c:forEach>
								
                            </span>
                        <span class="sku_wrapper big-font" id="size">
                                尺码:			    <c:forEach var="size" items="${good.sizes}" varStatus="status">
    							<c:if test="${status.index % 4 == 0}">
        						<br /> <!-- 是表格就加个<tr></tr> -->
    							</c:if>
    							<button value="${size.sname}" class="btn btn-default btn-lg">${size.sname}</button>
								</c:forEach>
                            </span>
                    </div>

                    <div class="new_meta">
                            <span class="sku_wrapper big-font">
                                优惠券(点击领取):
                                    <c:if test="${!empty good.discounts}">
                                        <span class="span-block">
                                         <c:forEach var="discount" items="${good.discounts}" varStatus="status">
    										<button class="quan-item" id="discount" value="${discount.did}">满${discount.fullprice}减${discount.reduceprice}</button>
								</c:forEach>
                                            
                                        </span>
                                    </c:if>
                                <c:if test="${empty good.discounts}">
                                    <span class="sku">暂无优惠，敬请期待！</span>
                                </c:if>
                            </span>
                    </div>
                    <%--<div class="new_meta"></div>--%>

                    <div class="rel-div">
                    <div class="add_defi new_meta">
                    <span class="sku_wrapper big-font" id="color">
                                销售量:${good.salesvolume}
                                </span>
                        </div>
                        <div class="add_defi new_meta">
                            <a data-original-title="Add to Wishlist" data-toggle="tooltip" class="fav-button big-font" data-id="${good.gid}">
                                <c:if test="${fav}">
                                    <i class="fa fa-heart"></i>
                                    <span class="like-content" id="favorite">取消收藏</span>
                                </c:if>
                                <c:if test="${!fav}">
                                    <i class="fa fa-heart-o"></i>
                                    <span class="like-content" id="favorite">收藏</span>
                                </c:if>
                            </a>
                        </div>
                        <div class="cart-btn-area new_meta">
                        	<input type="hidden" name="shopsize" id="shopsize" value="">
                        	<input type="hidden" name="shopcolor" id="shopcolor" value="">
                            <input type="hidden" value="${good.gid}" name="gid" id="gid"/>
                            <input type="number" value="1" name="goodsnum" id="goodsnum" onchange="f(this)">
                            <script type="text/javascript">
                        	function f(obj) {
                				if($(obj).val()<1){
                					$(obj).val(1);
                					alert("最少为1！");
                				}
                			}
                            </script>
                            <button class="add-tocart cart_zpf" type="submit" id="addCart">加入购物车</button>
                            <button class="add-tocart cart_zpf" type="button" id="buy">立即购买</button>
                        </div>

                    </div>

                    <!-- <div class="add_defi_2">
                        <a data-original-title="Compare" title="" data-toggle="tooltip" rel="nofollow" data-product_id="45" href=""><i class="fa fa-refresh another_icon"></i> Compare</a>
                    </div> -->

                </div>
            </div>
            <!-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

        </div> -->
        </div>
    </div>
</div>
<!--zoom elavator area one end-->
<!--tab area start-->
<div class="tab_area_start">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 text-right">
                <div class="my-tabs">
                    <!-- Nav tabs -->
                    <ul class="favtabs favtabs-2 favtabs-nytr" role="tablist">
                        <%--<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Discription</a></li>--%>
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                                  data-toggle="tab">商品描述</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">评价
                            ${commentSize}</a></li>
                    </ul>
                           <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                                <div class="col-md-12 col-xs-12">
                                    <div class="tb_desc">
                                        <h2>商品描述</h2>
                                        <p>商品的详细描述</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <div role="tabpanel" class="tab-pane" id="profile">
                            <div class="row">
                                <div class="col-md-12 col-xs-12">
                                    <div class="tb_desc">
                                        <div class="review_area_heading">
                                            <div id="comnt">
                                                <h2>${commentSize}条评论</h2>
                                                <ol class="commentlist">
                                                    <c:forEach items="${good.comments}" var="comment">
                                                        <li id="li-comment-22" class="comment even thread-even depth-1"
                                                            itemscope="">
                                                            <div id="comment-22" class="comment_container">
                                                                <img class="head avatar avatar-60 photo "width="60" height="60"
                                                                     src="${pageContext.request.contextPath}/image/head.jpg" alt="">
                                                                <div class="comment-text">
                                                                    <div class="star-rating" title="Rated ${comment.rank} out of 5"
                                                                         itemscope="">
                                                                        <div class="price_rating price_rating_2">
                                                                          <c:forEach  begin="1" end="${comment.rank}">
                                                                              <a href="#">
                                                                                  <i class="fa fa-star"></i>
                                                                              </a>
                                                                          </c:forEach>
                       
                                                                        </div>
                                                                    </div>
                                                                    <p class="meta">
                                                                        <strong>${comment.user.username}</strong>
                                                                        –
                                                                        <time datetime="${comment.ctime}">
                                                                            ${comment.ctime.year+1900}年
                                                                            ${comment.ctime.month+1}月
                                                                            ${comment.ctime.date}日
                                                                        </time>
                                                                        :
                                                                        <a  href="${pageContext.request.contextPath}/chat?sendto=${comment.user.uid}" data-original-title="Add to Wishlist" data-toggle="tooltip" class=" big-font">
                                                                            <i class="fa fa-commenting"></i>
                                                                        </a>
                                                                    </p>
                                                                    <div class="description">
                                                                        <p>${comment.content}</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ol>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>


