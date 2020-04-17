var adminLogistics = {
	updateLogistics:function(){
		var lid;
		var lname;
		$("[name='update']").click(function(){
	        $("#update-logistics").modal({
	            backdrop:'static'
	        });
	        $("#updatelid").text($(this).parent().siblings('#lid').text());
	        $("#updatelname").val($(this).parent().siblings('#lname').text());
	        lid = $(this).parent().siblings('#lid').text();
		});
		$("#saveUpdate").click(function(){
			lname = $("#updatelname").val();
	        $.ajax({
		        url: "logisticsAction_updateLogistics",
		        type: "post",
		        data: {
		        	lid:lid,
		        	lname:lname,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-logistics").modal('hide');
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
	addLogistics:function(){
		$('#add').click(function(){
			 $("#add-logistics").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var lname = $('#addlname').val();
			        $.ajax({
				        url: "logisticsAction_addLogistics",
				        type: "post",
				        data: {
				        	lname:lname,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-logistics").modal('hide');
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
	deleteLogistics:function(){
		$("[name='delete']").click(function(){
			var lid = $(this).parent().siblings('#lid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "logisticsAction_deleteLogistics",
			        type: "post",
			        data: {
			        	lid:lid
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