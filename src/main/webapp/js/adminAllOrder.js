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
		agreeRefund:function(){
			var oid;
			$("[name='agree']").click(function() {
				oid = $(this).siblings("#oid").val();
				$.ajax({
			        url: "myorderAction_agreeRefund",
			        type: "post",
			        data: {
			        	oid:oid,
			        },
		            success: function(){
		                    swal("成功");
		                    location.reload();
		            },
		            error:function (){
		                alert("发送失败");
		            }
		        });
			});
		}
};