/*
$(document).ready(function(){
	$('.delete-goods').click(function(){
		var goodsid = $(this).attr("data-goodsid");
        alert("asfd");
		// deleteGoods(goodsid);
	});

	$('.confirm-orders').click(function(){
		confirmOrders();
		alert("已成功加入订单，并已发送邮件至卖家，请等待卖家回复！");
		location.href = "/index.jsp";
	});
});*/
/*
function deleteGoods(goodsid){
	$.post("servlet/DeleteCartServlet", { 
		goodsId: goodsid,
	});
}

function confirmOrders(){
	$.post("servlet/SaleServlet");
}*/
$(document).ready(function () {
    var path = $("#path").text();
    showcart();

    /*$('.delete-goods').click(function(){
        alert("adf");
        var goodsid = $(this).attr("data-goodsid");
        $.ajax({
            url: "/shop/deleteCart" + goodsid,
            type: "DELETE",
            success:function (result) {
                swal(result.msg, "","success");
                showcart();
            },
            error:function () {
                /!*to_page('/shop',currentPage);*!/
                swal("删除失败");
            }
        })
    });*/
});

/*$(document).on("click",".delete-good",function () {
    alert("afd");
});*/

function deleteCartGoods(scid) {
    $.ajax({
        url: "shopCartAction_deleteCart",
        data: {
        	scid:scid
        },
        method: "post",
        success: function (result) {
            // swal(result.msg, "","success");
            showcart();
        },
        error:function () {
            swal("删除失败");
        }
    })
}

//改变商品数量更新购物车
function updateCart(scid, newNum) {
    //获取当前数量
    // var newNum = $(".num").val();
    $.ajax({
        url: "shopCartAction_updateNum",
        data: {
            scid: scid,
            goodsnum:newNum
        },
        method: "post",
        success: function (result) {
            // swal(result.msg, "", "success");
            showcart();
        },
        error: function (result) {
            swal("更新购物车失败");
        }
    });
}

function showcart() {
    $.ajax({
        url: "shopCartAction_showShopCart",
        type: "post",
        success: function (cart) {
            //显示购物车
            build_cart_table(cart);
        },
        error: function (cart) {
            swal("获取购物车失败");
        }
    });
}

function build_cart_table(cart) {
    $("#cart-table tbody").empty();
    var goods = cart;
    var totalnum = 0;
    var totalMoney = 0;
    if(goods.length === 0) {
        var spareTd = $('<tr> <td colspan="6"> <div class="coupon" style="margin-left:37%;">购物车还是空的，快去<a href="/sportshop/main.jsp" style="color:red;">首页</a>看看吧！ </div> </td> </tr>');
        spareTd.appendTo("#cart-table tbody");
    } else {
        $.each(goods, function (index,item) {

            var delA = $("<a></a>").addClass("delete-goods").attr("data-goodsid",item.good.gid).append("×");
            var deleteCart = $("<td></td>").addClass("product-remove product-remove_2")
                .append(delA);

            delA.click(function () {
                deleteCartGoods(item.scid);
            });

            var shopimage = $("<td></td>").addClass("product-thumbnail product-thumbnail-2")
                .append($("<a></a>").attr("href","goodAction_showDetail?gid="+item.good.gid)
                    .append($("<img/>").attr("src","/sportshop/"+item.good.images+"/1.jpg")));

            var goodsname = $("<td></td>").addClass("product-name product-name_2")
                .append($("<a></a>").attr("href","goodAction_showDetail?gid="+item.good.gid).append(item.good.gname));
            var goodcolor = $("<td></td>").addClass("product-color")
            .append($("<span></span>").addClass("amount-list amount-list-2").append(item.shopcolor));
            var goodsize = $("<td></td>").addClass("product-size")
            .append($("<span></span>").addClass("amount-list amount-list-2").append(item.shopsize));
            if(item.user.isVip == "否"){
                var goodsprice = $("<td></td>").addClass("product-price")
                .append($("<span></span>").addClass("amount-list amount-list-2").append("普通价￥"+item.good.price));
            }else{
                var goodsprice = $("<td></td>").addClass("product-price")
                .append($("<span></span>").addClass("amount-list amount-list-2").append("会员价￥"+item.good.vipPrice));
            }
            
            var numIput = $("<input/>").addClass("num").attr("type","number").attr("value",item.goodsnum);

            var num = $("<td></td>").addClass("product-stock-status")
                .append($("<div></div>").addClass("latest_es_from_2")
                    .append(numIput));
            numIput.change(function () {
               updateCart(item.scid,$(this).val());
            });
            if(item.user.isVip == "否"){
                var totalPrice = $("<td></td>").addClass("product-price")
                .append($("<span></span>").addClass("amount-list amount-list-2").append("￥"+item.good.price*item.goodsnum));
            }else{
                var totalPrice = $("<td></td>").addClass("product-price")
                .append($("<span></span>").addClass("amount-list amount-list-2").append("￥"+item.good.vipPrice*item.goodsnum));
            }


            var goodsitem = $("<tr></tr>").append(deleteCart)
                .append(shopimage)
                .append(goodsname)
                .append(goodcolor)
                .append(goodsize)
                .append(goodsprice)
                .append(num)
                .append(totalPrice)
                .appendTo("#cart-table tbody");
            totalnum++;
            if(item.user.isVip == "否"){
                totalMoney = totalMoney + item.good.price*item.goodsnum;
            }else{
                totalMoney = totalMoney + item.good.vipPrice*item.goodsnum;
            }

        });
    }

    //小计
    $("#total-num").text(totalnum);
    $("#total-price").text("￥"+totalMoney);
    $("#totalPrice").val(totalMoney);
}
