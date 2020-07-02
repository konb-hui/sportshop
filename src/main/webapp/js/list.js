$(document).ready(function (){
   $("[name='deleteList']").click(function (){
       var oid = $(this).siblings("#oid").val();
		if(window.confirm("您确认删除吗?")){
		    $.ajax({
		        url: "myorderAction_deleteOrder",
		        type: "post",
		        data: {
		        	oid:oid
		        },
		        success: function (result) {
					swal("删除成功");
					location.reload();
		        },
		        error: function (result) {
		            swal("删除失败");
		        }
		    });
		}else{
			return false;//如果返回的是false,则表单不提交
		}
   });
   $("[name='refund']").click(function (){
       var oid = $(this).siblings("#oid").val();
		if(window.confirm("您确认申请退款吗?")){
		    $.ajax({
		        url: "myorderAction_refund",
		        type: "post",
		        data: {
		        	oid:oid
		        },
		        success: function (result) {
					swal("申请成功");
					location.reload();
		        },
		        error: function (result) {
		            swal("申请失败");
		        }
		    });
		}else{
			return false;//如果返回的是false,则表单不提交
		}
   });
   $("[name='cancelrefund']").click(function (){
       var oid = $(this).siblings("#oid").val();
		if(window.confirm("您确认取消申请退款吗?")){
		    $.ajax({
		        url: "myorderAction_cancelrefund",
		        type: "post",
		        data: {
		        	oid:oid
		        },
		        success: function (result) {
					swal("取消成功");
					location.reload();
		        },
		        error: function (result) {
		            swal("取消失败");
		        }
		    });
		}else{
			return false;//如果返回的是false,则表单不提交
		}
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
    });
    $("[name='pay']").click(function() {
    	$("#pay").modal({
            backdrop:'static'
        });
    	$("#paymoney").text($(this).siblings("#money").val()+"元");
    	var oid = $(this).siblings("#oid").val();
    	$("#savePay").click(function(){
    	    $.ajax({
    	        url: "myorderAction_payOrder",
    	        type: "post",
    	        data: {
    	        	oid:oid
    	        },
    	        success: function (result) {
    				swal("付款成功！");
    				location.reload();
    				
    	        },
    	        error: function (result) {
    	            swal("付款失败");
    	        }
    	    });
    	});
	});
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