var adminManage = {
	updateAdmin:function(){
		var adminId;
		var rid;
		$("[name='update']").click(function(){
	        $("#update-admin").modal({
	            backdrop:'static'
	        });
	        $("#updaterole").val($(this).siblings('#adminRid').val());
	        $("#updateadminId").text($(this).parent().siblings('#adminId').text());
	        adminId = $(this).parent().siblings('#adminId').text();
		});
		$("#saveUpdate").click(function(){
			rid = $("#updaterole").val();
	        $.ajax({
		        url: "adminAction_updateAdmin",
		        type: "post",
		        data: {
		        	adminId:adminId,
		        	rid:rid,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-admin").modal('hide');
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
	addAdmin:function(){
		$('#add').click(function(){
			 $("#add-admin").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var adminName = $('#addadminName').val();
					var password = $('#addpassword').val();
					var phone = $('#addphone').val();
					var sex = $('#addsex').val();
					var trueName = $('#addtrueName').val();
					var email = $('#addemail').val();
					var rid = $('#addrole').val();
			        $.ajax({
				        url: "adminAction_addAdmin",
				        type: "post",
				        data: {
				        	adminName:adminName,
				        	password:password,
				        	phone:phone,
				        	sex:sex,
				        	trueName:trueName,
				        	email:email,
				        	rid:rid,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#add-admin").modal('hide');
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
	deleteAdmin:function(){
		$("[name='delete']").click(function(){
			var adminId = $(this).parent().siblings('#adminId').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "adminAction_deleteAdmin",
			        type: "post",
			        data: {
			        	adminId:adminId
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
	changesex:function(){
		$("#changesex").change(function(){
			var sex = $(this).val();
			var rid = $("#changerole").val();
			if(sex != "选择"){
				if(rid != "选择"){
					window.location.href = $("body").data("url") + "?sex=" + sex + "&rid=" + rid;
				}else{
					window.location.href = $("body").data("url") + "?sex=" + sex;
				}
			}else{
				window.location.href = $("body").data("url");
			}
		});
	},
	changerole:function(){
		$("#changerole").change(function(){
			var rid = $(this).val();
			var sex = $("#changesex").val();
			if(rid != "选择"){
				if(sex != "选择"){
					window.location.href = $("body").data("url") + "?sex=" + sex + "&rid=" + rid;
				}else{
					window.location.href = $("body").data("url") + "?rid=" + rid;
				}
			}else{
				window.location.href = $("body").data("url");
			}
		});
	},
	search:function(){
		$("#search").click(function() {
			var key = $("#key").val();
			if(key.trim() != ""){
				window.location.href = $("body").data("url") + "?key=" + key;
			}
		});
	},
};