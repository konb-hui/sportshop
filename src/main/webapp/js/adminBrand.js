var adminBrand = {
	updateBrand:function(){
		var bid;
		var bname;
		$("[name='update']").click(function(){
	        $("#update-brand").modal({
	            backdrop:'static'
	        });
	        $("#updatebid").text($(this).parent().siblings('#bid').text());
	        $("#updatebname").val($(this).parent().siblings('#bname').text());
	        bid = $(this).parent().siblings('#bid').text();
		});
		$("#saveUpdate").click(function(){
			bname = $("#updatebname").val();
	        $.ajax({
		        url: "brandAction_updateBrand",
		        type: "post",
		        data: {
		        	bid:bid,
		        	bname:bname,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-brand").modal('hide');
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
	searchForName:function(){
		$('#search').click(function(){
			var bname = $('#bname').val();
			if(bname != ""){
				 window.location.href = "brandAction_listBrand?bname=" + bname;
			}
		});
	},
	addBrand:function(){
		$('#add').click(function(){
			 $("#add-brand").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var bname = $('#addbname').val();
			        $.ajax({
				        url: "brandAction_addBrand",
				        type: "post",
				        data: {
				        	bname:bname,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#update-brand").modal('hide');
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
	deleteBrand:function(){
		$("[name='delete']").click(function(){
			var bid = $(this).parent().siblings('#bid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "brandAction_deleteBrand",
			        type: "post",
			        data: {
			        	bid:bid
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