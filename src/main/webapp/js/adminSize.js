var adminSize = {
	updateSize:function(){
		var sid;
		var sname;
		$("[name='update']").click(function(){
	        $("#update-size").modal({
	            backdrop:'static'
	        });
	        $("#updatesid").text($(this).parent().siblings('#sid').text());
	        $("#updatesname").val($(this).parent().siblings('#sname').text());
	        sid = $(this).parent().siblings('#sid').text();
		});
		$("#saveUpdate").click(function(){
			sname = $("#updatesname").val();
	        $.ajax({
		        url: "sizeAction_updateSize",
		        type: "post",
		        data: {
		        	sid:sid,
		        	sname:sname,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-size").modal('hide');
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
	addSize:function(){
		$('#add').click(function(){
			 $("#add-size").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var sname = $('#addsname').val();
					var gid = $(this).siblings('#gid').val();
			        $.ajax({
				        url: "sizeAction_addSize",
				        type: "post",
				        data: {
				        	sname:sname,
				        	gid:gid,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-size").modal('hide');
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
	deleteSize:function(){
		$("[name='delete']").click(function(){
			var sid = $(this).parent().siblings('#sid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "sizeAction_deleteSize",
			        type: "post",
			        data: {
			        	sid:sid
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