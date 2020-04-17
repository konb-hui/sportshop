var adminRole = {
	updateRole:function(){
		var rid;
		var rname;
		$("[name='update']").click(function(){
	        $("#update-role").modal({
	            backdrop:'static'
	        });
	        $("#updaterid").text($(this).parent().siblings('#rid').text());
	        $("#updatername").val($(this).parent().siblings('#rname').text());
	        rid = $(this).parent().siblings('#rid').text();
		});
		$("#saveUpdate").click(function(){
			rname = $("#updatername").val();
	        $.ajax({
		        url: "roleAction_updateRole",
		        type: "post",
		        data: {
		        	rid:rid,
		        	rname:rname,
		        },
	            success: function(result){
	                if (result.msg!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-role").modal('hide');
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
	addRole:function(){
		$('#add').click(function(){
			 $("#add-role").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var rname = $('#addrname').val();
			        $.ajax({
				        url: "roleAction_addRole",
				        type: "post",
				        data: {
				        	rname:rname,
				        },
			            success: function(result){
			                if (result.msg!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-role").modal('hide');
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
	deleteRole:function(){
		$("[name='delete']").click(function(){
			var rid = $(this).parent().siblings('#rid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "roleAction_deleteRole",
			        type: "post",
			        data: {
			        	rid:rid
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
	updateprivilege:function(){
		$("[name='updateprivilege']").click(function(){
			$("#updateprivilege-role").modal({
	            backdrop:'static'
	        });
			var rid = $(this).parent().siblings("#rid").text();
	        $.ajax({
		        url: "roleAction_findPrivilegeByRole",
		        type: "post",
		        data: {
		        	rid:rid,
		        },
	            success: function(result){
	            	var list = result.list;
	                for(var i = 0; i < list.length;i++){
	                	$("#"+list[i].pid).prop("checked",true);
	                }
	            },
	            error:function (){
	                alert("加载失败");
	            }
	        });
	        $("#saveUpdateprivilege").click(function(){
	        	var pid = "";
	        	$('input[name="privilege"]:checked').each(function(){
	        		pid = pid + $(this).val() + ",";
	        	});
		        $.ajax({
			        url: "roleAction_updatePrivilege",
			        type: "post",
			        data: {
			        	pid:pid,
			        	rid:rid,
			        },
		            success: function(result){
		            	swal(result);
		            	location.reload();
		            },
		            error:function (){
		                alert("配置失败");
		            }
		        });
	        });
		});
	},
};