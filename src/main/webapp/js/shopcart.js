
$(document).ready(function () {
    var path = $("#path").text();
    var totalprice = 0;
    $("table tr").each(function() {
    	var str = $(this).find('td').eq(7).text();
		 if(str.length != 0){
			 str = str.substr(1,str.length).trim();
			 totalprice = totalprice + parseInt(str); 
		 }
	});
    $("#total-price").text("￥"+totalprice);
    $("#totalPrice").val(totalprice);
});

/*$(document).on("click",".delete-good",function () {
    alert("afd");
});*/

function deleteCartGoods(obj) {
	var scid = $(obj).val();
    $.ajax({
        url: "shopCartAction_deleteCart",
        data: {
        	scid:scid
        },
        method: "post",
        success: function (result) {
        	location.reload();
        },
        error:function () {
            swal("删除失败");
        }
    });
}

//改变商品数量更新购物车
function updateCart(obj) {
	if($(obj).val() < 1){
		$(obj).val(1);
		alert("最少为一件");
	}else{
	    var goodsnum = $(obj).val();
	    var scid = $(obj).siblings("#scid").val();
	    $.ajax({
	        url: "shopCartAction_updateNum",
	        data: {
	            scid: scid,
	            goodsnum:goodsnum,
	        },
	        method: "post",
	        success: function (result) {
	        	location.reload();
	        },
	        error: function (result) {
	            swal("更新购物车失败");
	        }
	    });
	}
}