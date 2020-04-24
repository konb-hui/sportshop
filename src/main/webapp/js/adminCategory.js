var adminCategory = {
	updateCategory:function(){
		var cid;
		var cname;
		$("[name='update']").click(function(){
	        $("#update-category").modal({
	            backdrop:'static'
	        });
	        $("#updatecid").text($(this).parent().siblings('#cid').text());
	        $("#updatecname").val($(this).parent().siblings('#cname').text());
	        cid = $(this).parent().siblings('#cid').text();
		});
		$("#saveUpdate").click(function(){
			cname = $("#updatecname").val();
	        $.ajax({
		        url: "categoryAction_updateCategory",
		        type: "post",
		        data: {
		        	cid:cid,
		        	cname:cname,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-category").modal('hide');
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
			var key = $('#key').val();
			if(key.trim() != ""){
				 window.location.href = "categoryAction_listCategory?key=" + key;
			}
		});
	},
	addCategory:function(){
		$('#add').click(function(){
			 $("#add-category").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var cname = $('#addcname').val();
			        $.ajax({
				        url: "categoryAction_addCategory",
				        type: "post",
				        data: {
				        	cname:cname,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#update-category").modal('hide');
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
	deleteCategory:function(){
		$("[name='delete']").click(function(){
			var cid = $(this).parent().siblings('#cid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "categoryAction_deleteCategory",
			        type: "post",
			        data: {
			        	cid:cid
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