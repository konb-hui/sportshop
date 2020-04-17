/**
 * Created by 文辉 on 2017/7/25.
 */
$(document).ready(function () {
    $("#confirm-orders").click(function () {
        // alert("safd");
        var selectAddr =  $('input:radio[name="aid"]:checked').val();
        if(selectAddr == null) {
            swal("请先添加地址");
            return;
        }
        var isPay = "未发货";
        var oldPrice = $('#total-old').text();
        var newPrice = $('#newPrice').text();
        $.ajax({
            url: "myorderAction_addOrder",
            type: "POST",
            data: {
                price: oldPrice,
                newprice: newPrice,
                status: isPay,
                aid: selectAddr
            },
            success: function () {
                swal("购买成功", "", "success");
                location.href = "myorderAction_listOrder"
            },
            error: function () {
                swal("购买失败，无法连接到服务器！");
            }
        });
    });
});