$(document).ready(function (){
   $("[name='deleteList']").click(function (){
       var orderid=$(this).parents("[name='parent']").find("[name='orderid']").text();
       var order={};
       order.orderid= parseInt(orderid);
       $.ajax({
           type:"POST",
           url:"/shop/deleteList",
           contentType:"application/x-www-form-urlencoded; charset=utf-8",
           data:order,
           dataType:"json",
           success:function (result){
               swal(result.msg);
               $("button").click(function (){
                   location.reload();
               });
           },
           error:function (){
               alert("删除失败");
           }
       });
   });

    $("[name='finishList']").click(function (){
        var oid=$(this).siblings("#oid").val();
		if(window.confirm("您确认收货吗?")){
		    $.ajax({
		        url: "myorderAction_completedOrder",
		        type: "post",
		        data: {
		        	oid:oid
		        },
		        success: function (result) {
					swal("收货成功！");
					location.reload();
		        },
		        error: function (result) {
		            swal("收货失败");
		        }
		    });
		}else{
			return false;//如果返回的是false,则表单不提交
		}
    })

    var gid;
    var hid;
    $("[name='evaluate']").click(function (){
        $("#evaluate").modal({
            backdrop:'static'
        });
        gid=$(this).siblings("#gid").val();
        hid = $(this).siblings("#hid").val();
    })

    $("#star").raty({path: '/sportshop/image/img'});

    $("#saveEvaluate").click(function (){
        var rank=$("[name='score']").val();
        var content=$("#description").val();
	    $.ajax({
	        url: "commentAction_addComment",
	        type: "post",
	        data: {
	        	gid:gid,
	        	hid:hid,
	        	rank:rank,
	        	content:content,
	        },
	        success: function (result) {
				swal("评论成功！");
				location.reload();
				
	        },
	        error: function (result) {
	            swal("评论失败");
	        }
	    });


    })

});