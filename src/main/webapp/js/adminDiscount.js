var adminDiscount = {
	updateDiscount:function(){
		var did;
		var fullprice;
		var reduceprice;
		$("[name='update']").click(function(){
	        $("#update-discount").modal({
	            backdrop:'static'
	        });
	        $("#updatedid").text($(this).parent().siblings('#did').text());
	        $("#updatefullprice").val($(this).parent().siblings('#fullprice').text());
	        $("#updatereduceprice").val($(this).parent().siblings('#reduceprice').text());
	        did = $(this).parent().siblings('#did').text();
		});
		$("#saveUpdate").click(function(){
			fullprice = $("#updatefullprice").val();
			reduceprice = $("#updatereduceprice").val();
	        $.ajax({
		        url: "discountAction_updateDiscount",
		        type: "post",
		        data: {
		        	did:did,
		        	fullprice:fullprice,
		        	reduceprice:reduceprice,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-discount").modal('hide');
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
	},
	addDiscount:function(){
		$('#add').click(function(){
			 $("#add-discount").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var fullprice = $('#addfullprice').val();
					var reduceprice = $('#addreduceprice').val();
					var gid = $(this).siblings('#gid').val();
			        $.ajax({
				        url: "discountAction_addDiscount",
				        type: "post",
				        data: {
				        	fullprice:fullprice,
				        	reduceprice:reduceprice,
				        	gid:gid,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-discount").modal('hide');
			                    swal("添加成功", "", "success");
			                    $("button").click(function (){
			                        location.reload();
			                    });
			                }
			            },
			            error:function (){
			                alert("添加失败");
			            }
			        });
				});
		});
	},
	deleteDiscount:function(){
		$("[name='delete']").click(function(){
			var did = $(this).parent().siblings('#did').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "discountAction_deleteDiscount",
			        type: "post",
			        data: {
			        	did:did
			        },
			        success: function (result) {
						swal("删除成功！");
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
	},
};