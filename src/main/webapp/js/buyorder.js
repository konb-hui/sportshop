
$(document).ready(function () {
    $("#confirm-orders").click(function () {
        // alert("safd");
        var selectAddr =  $('input:radio[name="aid"]:checked').val();
        if(selectAddr == null) {
            swal("请先添加地址");
            return;
        }
        var isPay = "未付款";
        var oldPrice = $('#total-old').text();
        var newPrice = $('#newPrice').text();
        $.ajax({
            url: "myorderAction_addBuyOrder",
            type: "POST",
            data: {
                price: oldPrice,
                newprice: newPrice,
                status: isPay,
                aid: selectAddr
            },
            success: function () {
                location.href = "myorderAction_toPay"
            },
            error: function () {
                swal("购买失败，无法连接到服务器！");
            }
        });
    });
});