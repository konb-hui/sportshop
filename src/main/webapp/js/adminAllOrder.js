var adminAllOrder = {
		sendGood:function(){
			var oid;
			var lid;
			$("[name='send']").click(function(){
				 $("#send-order").modal({
			            backdrop:'static'
			        });
				 oid = $(this).siblings("#oid").val();
				 $('#saveSend').click(function(){
					 lid = $("#logistics").val();
				        $.ajax({
					        url: "myorderAction_changeStatus",
					        type: "post",
					        data: {
					        	oid:oid,
					        	lid:lid,
					        },
				            success: function(result){
				                    $("#send-order").modal('hide');
				                    swal("发送成功", "", "success");
				                    $("button").click(function (){
				                        location.reload();
				                    });
				            },
				            error:function (){
				                alert("发送失败");
				            }
				        });
				 });
			});
		},
};