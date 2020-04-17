var adminColor = {
	updateColor:function(){
		var coid;
		var coname;
		$("[name='update']").click(function(){
	        $("#update-color").modal({
	            backdrop:'static'
	        });
	        $("#updatecoid").text($(this).parent().siblings('#coid').text());
	        $("#updateconame").val($(this).parent().siblings('#coname').text());
	        coid = $(this).parent().siblings('#coid').text();
		});
		$("#saveUpdate").click(function(){
			coname = $("#updateconame").val();
	        $.ajax({
		        url: "colorAction_updateColor",
		        type: "post",
		        data: {
		        	coid:coid,
		        	coname:coname,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-color").modal('hide');
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
	addColor:function(){
		$('#add').click(function(){
			 $("#add-color").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var coname = $('#addconame').val();
					var gid = $(this).siblings('#gid').val();
			        $.ajax({
				        url: "colorAction_addColor",
				        type: "post",
				        data: {
				        	coname:coname,
				        	gid:gid,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-color").modal('hide');
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
	deleteColor:function(){
		$("[name='delete']").click(function(){
			var coid = $(this).parent().siblings('#coid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "colorAction_deleteColor",
			        type: "post",
			        data: {
			        	coid:coid
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