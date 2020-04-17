<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>淘一淘</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopcart.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css">
    <script src="${pageContext.request.contextPath}/js/order.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$("table tr").each(function(){
		 $(this).find('td').eq(6).children().change(function(){
			 var reduce = $(this).children('option:selected').val();
			 var str = $(this).parent().siblings(".product-totalprice").children("#firstprice").val();
			 var newprice = str - reduce;
			 $(this).parent().siblings(".product-totalprice").children().text("￥"+newprice);
			 changetotalp();
		 });
	});
});
function changetotalp() {
	var newtotalp = 0;
	$("table tr").each(function(){
		 var str = $(this).find('td').eq(7).text();
		 if(str.length != 0){
			 str = str.substr(1,str.length).trim();
			 newtotalp = newtotalp + parseInt(str); 
		 }
	});
	$("#newPrice").text(newtotalp);
}
</script>
<body>
<div id="main" class="container">
    <jsp:include page="header.jsp"/>
</div>
<div class="shopping_cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="account_heading account_heading_ah">
                    <h1 class="header-border">确认订单</h1>
                </div>
            </div>
        </div>

        <%--确认收货地址--%>
        <h4 class="header-border h4-mar">确认收货地址<a href="userAction_address" class="pull-right manage-a">管理收货地址</a></h4>

        <%--<form action="" method="post">--%>
        <div class="address">
            <c:forEach items="${user.addresses}" var="addItem">
                <div class="radio">
                    <label>
                        <input type="radio" name="aid" class="address-check" value="${addItem.aid}"
                               checked>
                            ${addItem.province} ${addItem.city} ${addItem.county}  ${addItem.detailaddr}（${addItem.conname}收）${addItem.contel}
                    </label>
                </div>
            </c:forEach>
        </div>

        <%--商品信息--%>
        <h4 class="header-border h4-mar-2">确认收货信息</h4>
        <div class="row">
            <div class="all_wis_frm">
                <div class="col-md-12">
                    <div class="wishlist-content wishlist-content-2">

                        <div class="wishlist-table wishlist-table-2 table-responsive">
                            <table id="cart-table">
                                <thead>
                                <tr>
                                    <th class="product-thumbnail product-thumbnail-2"></th>
                                    <th class="product-name product-name_2"><span
                                            class="nobr">商品</span></th>
                                     <th class="product-color"><span
                                            class="nobr">颜色</span></th>
                                    <th class="product-size"><span
                                            class="nobr">尺寸</span></th>
                                    <th class="product-price"><span class="nobr"> 价格
												</span></th>
                                    <th class="product-stock-stauts"><span class="nobr">
														数量 </span></th>
                                    <th class="product-discount"><span class="nobr">
														优惠券 </span></th>
                                    <th class="product-add-to-cart"><span class="nobr">总价</span></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--<c:set var="oldTotalPrice" value="0"/>--%>
                                <c:forEach items="${user.shopCarts}" var="goods">
                                    <tr>
                                        <td class="product-thumbnail product-thumbnail-2"><a
                                                href="goodAction_showDetail?gid=${goods.good.gid}"><img
                                                src="/sportshop/${goods.good.images}/1.jpg"
                                                alt=""/></a></td>
                                        <td class="product-name product-name_2"><a
                                                href="goodAction_showDetail?gid=${goods.good.gid}">${goods.good.gname}</a>
                                        </td>
                                        <td class="product-color">
                                        	<span class="amount-list amount-list-2">${goods.shopcolor}</span>
                                        </td>
                                        <td class="product-size">
                          					<span class="amount-list amount-list-2">${goods.shopsize}</span>              
                                        </td>
                                        <c:if test="${goods.user.isvip eq '否'}">
                                        <td class="product-price"><span
                                                class="amount-list amount-list-2">普通价￥${goods.good.price}</span></td>
                                        </c:if>
                                        <c:if test="${goods.user.isvip eq '是'}">
                                        <td class="product-price">
                                        <span class="amount-list amount-list-2">会员价￥${goods.good.vipPrice}</span></td>
                                        </c:if>
                                        <td class="product-stock-status">
                                            <div class="latest_es_from_2">
                                                <span>${goods.goodsnum}</span>
                                            </div>
                                        </td>
                                         <td class="product-discount">
                                    				<select class="form-control" id="discount-select">
                                    				<option value="0">不使用</option>
                                        				<c:forEach items="${goods.discounts}" var="discount">
                                        				<c:if test="${goods.user.isvip eq '否'}">
                                        					<c:if test="${discount.fullprice < (goods.good.price*goods.goodsnum)}">
                                        						<option value="${discount.reduceprice}">满${discount.fullprice}减${discount.reduceprice}</option>
                                        					</c:if>
                                        				</c:if>
                                        				<c:if test="${goods.user.isvip eq '是'}">
                                        					<c:if test="${discount.fullprice < (goods.good.vipPrice*goods.goodsnum)}">
                                        						<option value="${discount.reduceprice}">满${discount.fullprice}减${discount.reduceprice}</option>
                                        					</c:if>
                                        				</c:if>	
                                        				</c:forEach>
                                    				</select>
                            				</td>
                                        <c:if test="${goods.user.isvip eq '否'}">
                                        <td class="product-totalprice"><span class="amount-list amount-list-2">￥${goods.good.price*goods.goodsnum}</span><input type = "hidden" value="${goods.good.price*goods.goodsnum}" id="firstprice"></td>
                                        </c:if>
                                        <c:if test="${goods.user.isvip eq '是'}">
                                        <td class="product-totalprice"><span class="amount-list amount-list-2" >￥${goods.good.vipPrice*goods.goodsnum}</span>
                                        <input type = "hidden" value="${goods.good.vipPrice*goods.goodsnum}" id="firstprice"></td>
                                        </c:if>
                                        <%--<c:set value="${oldTotalPrice+goods.price*goods.num*goods.activity.discount}" var="oldTotalPrice"/>--%>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-md-offset-1 col-xs-12">
                                <div class="cart_totals">
                                    <h2>总价</h2>
                                    <table class="shop_table shop_table_responsive">
                                        <tbody>
                                        <tr class="cart-subtotal">
                                            <th>原价</th>
                                            <td data-title="Subtotal"><span
                                                    class="woocommerce-Price-amount amount">￥<span
                                                    class="woocommerce-Price-currencySymbol"
                                                    id="total-old">${totalPrice}</span>
													</span></td>
                                        </tr>
                                        
                                        <tr class="order-total">
                                            <th>实付款</th>
                                            <td data-title="Total"><strong> <span
                                                    class="woocommerce-Price-amount amount">￥<span
                                                    class="woocommerce-Price-currencySymbol"
                                                    id="total-new"></span><span id="newPrice">${newPrice}</span>
														</span>
                                            </strong></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input type="hidden" value="${totalPrice}" id="totalprice" name="totalprice">
                                    <div class="wc-proceed-to-checkout">
                                        <%--<input type="submit" class="button_act button_act-tc confirm-orders" value="结算"/>--%>
                                        <button id="confirm-orders"
                                                class="button_act button_act-tc confirm-orders pull-right">结算
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--</form>--%>

    </div>
</div>
<div id="path" hidden>${pageContext.request.contextPath}</div>
</body>
</html>

