
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>淘一淘-购物车</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopcart.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
    <script src="${pageContext.request.contextPath}/js/shopcart.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
</head>
<body>
<div id="main" class="container">
    <jsp:include page="header.jsp"/>
</div>
<div class="shopping_cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="account_heading account_heading_ah">
                    <h1>购物车</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="all_wis_frm">
                <div class="col-md-12">
                    <div class="wishlist-content wishlist-content-2">
                        <form action="#">
                            <div class="wishlist-table wishlist-table-2 table-responsive">
                                <table id="cart-table">
                                    <thead>
                                    <tr>
                                        <th class="product-remove"><span class="nobr"></span></th>
                                        <th class="product-thumbnail product-thumbnail-2"></th>
                                        <th class="product-name product-name_2"><span
                                                class="nobr">商品</span></th>
                                        <th class="product-color"><span class="nobr"> 颜色
										</span></th>
										<th class="product-size"><span class="nobr"> 尺寸
										</span></th>
                                        <th class="product-price"><span class="nobr"> 价格
												</span></th>
                                        <th class="product-stock-stauts"><span class="nobr">
														数量 </span></th>
										<th class="product-add-to-cart"><span class="nobr">总价</span></th>

                                    </tr>
                                    </thead>
                                    <tbody>
									<c:if test="${fn:length(shopcarts.shopcart) == 0}">
                                    	<tr> <td colspan="6"> <div class="coupon" style="margin-left:37%;">购物车还是空的，快去<a href="/sportshop/main.jsp" style="color:red;">首页</a>看看吧！ </div> </td> </tr>
                                    </c:if>
									<c:forEach items="${shopcarts.shopcart}" var="item">
									<tr>
										<td class="product-remove product-remove_2"><button class="glyphicon glyphicon-trash btn btn-default" value="${item.scid}" onclick="deleteCartGoods(this)"></button></td>
										<td class="product-thumbnail product-thumbnail-2"><a href="goodAction_showDetail?gid="+${item.good.gid}"><img src="/sportshop/${item.good.images}/1.jpg"/></a></td>
										<td class="product-name product-name_2"><a href="goodAction_showDetail?gid="+${item.good.gid}">${item.good.gname}</a></td>
										<td class="product-color"><span class="amount-list amount-list-2">${item.shopcolor}</span></td>
										<td class="product-size"><span class="amount-list amount-list-2">${item.shopsize}</span></td>
										<c:if test="${shopcarts.vip eq '否'}">
										<td class="product-price"><span class="amount-list amount-list-2">普通价￥${item.good.price}</span></td>
										</c:if>
										<c:if test="${shopcarts.vip eq '是'}">
										<td class="product-price"><span class="amount-list amount-list-2">会员价￥${item.good.vipPrice}</span></td>
										</c:if>
										<td class="product-stock-status"><div class="latest_es_from_2"><input class="num" type="number" value="${item.goodsnum}" onchange="updateCart(this)">
											<input type="hidden" id="scid" value="${item.scid}">
										</div></td>
										<c:if test="${shopcarts.vip eq '否'}">
										<td class="product-price"><span class="amount-list amount-list-2">￥${item.good.price*item.goodsnum}</span></td>
										</c:if>
										<c:if test="${shopcarts.vip eq '是'}">
										<td class="product-price"><span class="amount-list amount-list-2">￥${item.good.vipPrice*item.goodsnum}</span></td>
										</c:if>
									</tr>
									</c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-md-6 col-xs-12">
                                <div class="cart_totals ">
                                    <h2>总价</h2>
                                    <table class="shop_table shop_table_responsive">
                                        <tbody>
                                        <tr class="cart-subtotal">
                                            <th>小计</th>
                                            <td data-title="Subtotal"><span
                                                    class="woocommerce-Price-amount amount"> <span
                                                    class="woocommerce-Price-currencySymbol" id="total-num">${fn:length(shopcarts.shopcart)}</span>
													</span></td>
                                        </tr>
                                        <tr class="order-total">
                                            <th>总额</th>
                                            <td data-title="Total"><strong> <span
                                                    class="woocommerce-Price-amount amount"> <span
                                                    class="woocommerce-Price-currencySymbol" id="total-price"></span>
														</span>
                                            </strong></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <div class="wc-proceed-to-checkout">
                                    <form action="myorderAction_confirmOrder">
                                    	<input type="hidden" id="totalPrice" value="" name="totalPrice">
                                        <button class="button_act button_act-tc confirm-orders" type="submit">确认订单</button>
                                    </form>	
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-xs-12"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="path" hidden>${pageContext.request.contextPath}</div>
</body>
</html>
