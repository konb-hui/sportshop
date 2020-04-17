$(document).ready(function (){
    var aid;
    var detailaddressflag = 1;
    var nameflag = 1;
    var telephoneflag = 1;
    $("[name='changeAddr']").click(function (){
        $("#update-addr").modal({
            backdrop:'static'
        });
        $("#name").val($(this).parents("#parent").find("#conname").text());
        $("#telephone").val($(this).parents("#parent").find("#contel").text());
        $("#detailaddress").val($(this).parents("#parent").find("#detailaddr").text());
         aid=$(this).parents("#parent").find("#table").attr("address-id");

    });


    $("#saveAddr").click(function (){
        var saveAddr={};
        saveAddr.aid=aid;
         saveAddr.province=$("#provinceUpdate").val();
         saveAddr.city=$("#cityUpdate").val();
         saveAddr.county=$("#countyUpdate").val();
         saveAddr.detailaddr=$("#detailaddress").val();
         saveAddr.conname=$("#name").val();
         saveAddr.contel=$("#telephone").val();

        $.ajax({
            type: "POST",
            url: "./addressAction_updateAddress",
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            data:saveAddr,
            dateType:"json",
            success: function(result){
                if (result=="更新失败")
                {
                    swal(result);
                }
                else {
                    $("#update-info").modal('hide');
                    swal("修改成功", "", "success");
                    $("button").click(function (){
                        location.reload();
                    });
                }
            },
            error:function (){
                alert("更新失败");
            }
        });
    });

    $("[name='deleteAddr']").click(function (){
        aid=$(this).parents("#parent").find("#table").attr("address-id");
        var address={};
        address.aid=aid;
        $.ajax({
            type: "POST",
            url: "./addressAction_deleteAddress",
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            data:address,
            dateType:"json",
            success:function (result){
                swal(result);
                $("button").click(function (){
                    location.reload();
                });
            },
            error:function (){
                alert("删除失败");
            }
            });
    });

    $("[name='insertAddr']").click(function () {
        $("#insert-addr").modal({
            backdrop:'static'
        });
    });
    $("#nameInsert").blur(function (){
        if ($("#nameInsert").val().length == 0)
        {
        	$("#nameLabel").html("收货人不能为空！");
        	nameflag=0;
            $("#nameError").show();
        }else if($("#nameInsert").val().length > 10){
        	$("#nameLabel").html("收货人不能太长！");
        	nameflag=0;
            $("#nameError").show();
        }
        else
        {
            $("nameError").hide();
            nameflag=1;
        }
    })
        $("#detailaddressInsert").blur(function (){
        if ($("#detailaddressInsert").val().length == 0)
        {
        	$("#detailaddressLabel").html("详细地址不能为空！");
        	detailaddressflag=0;
            $("#detailaddressError").show();
        }else if($("#detailaddressInsert").val().length > 16){
        	$("#detailaddressLabel").html("详细地址不能太长！");
        	detailaddressflag=0;
            $("#detailaddressError").show();
        }
        else
        {
            $("#detailaddressError").hide();
            detailaddressflag=1;
        }
    })
        $("#telephoneInsert").blur(function (){
        if ($("#telephoneInsert").val().length == 0)
        {
        	$("#telephoneLabel").html("联系电话不能为空！");
        	telephoneflag=0;
            $("#telephoneError").show();
        }else if($("#telephoneInsert").val().length != 11){
        	$("#telephoneLabel").html("联系电话不正确！");
        	telephoneflag=0;
            $("#telephoneError").show();
        }
        else
        {
            $("telephoneError").hide();
            telephoneflag=1;
        }
    })
    $("#insertAddr").click(function (){
    	if(detailaddressflag==1&&nameflag==1&&telephoneflag==1){
            var insertAddr={};
            insertAddr.addressid={};
            insertAddr.userid={};
           insertAddr.province=$("#provinceInsert").val();
           insertAddr.city=$("#cityInsert").val();
            insertAddr.county=$("#countyInsert").val();
            insertAddr.detailaddr=$("#detailaddressInsert").val();
            insertAddr.conname=$("#nameInsert").val();
           insertAddr.contel=$("#telephoneInsert").val();
           $.ajax({
               type:"POST",
               url:"./addressAction_addAddress",
               contentType:"application/x-www-form-urlencoded; charset=utf-8",
               data:insertAddr,
               dataType:"json",
               success:function (result){
            	   swal(result);
                   $("button").click(function (){
                       location.reload();
                   });
               },
               error:function (){
                   alert("添加失败");
               }
           });
    	}

    });
});