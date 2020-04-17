var adminImages = {
		updateImages:function(){
			$("[name='update']").click(function(){
				var path = $(this).siblings('#image').val();
				var gid = $('#gid').val();
		        $.ajax({
			        url: "goodAction_updateImage",
			        type: "post",
			        data: {
			        	path:path,
			        	gid:gid,
			        },
		            success: function(result){
		                    swal("设置成功", "", "success");
		                    $("button").click(function (){
		                        location.reload();
		                    });
		            },
		            error:function (){
		                alert("更新失败");
		            }
		        });
			});
		},
		addImages:function(){
			$('#upimage').click(function() {
			    var formData = new FormData();
			    formData.append('image',$('#add')[0].files[0]);
			    formData.append('gid',$('#gid').val());
			    var path = $('#add').val();
			    extStart = path.lastIndexOf('.');
			    ext = path.substring(extStart,path.length).toUpperCase();
			    if(ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF'){
			    	alert("请上传正确的图片格式！");
			    }else{
			        $.ajax({
				        url: "goodAction_addImage",
				        type: "post",
				        data: formData,
				        cache: false,
			            processData: false,// 不处理数据
			            contentType: false, // 不设置内容类型
			            success: function(result){
			                    swal("添加成功", "", "success");
			                    $("button").click(function (){
			                        location.reload();
			                    });
			            },
			            error:function (){
			                alert("添加失败");
			            }
			        });
			    }
			});
		},
		deleteImages:function(){
			$("[name='delete']").click(function(){
				var path = $(this).siblings('#image').val();
				var gid = $('#gid').val();
		        $.ajax({
			        url: "goodAction_deleteImage",
			        type: "post",
			        data: {
			        	path:path,
			        	gid:gid,
			        },
		            success: function(result){
		                    swal("删除成功", "", "success");
		                    $("button").click(function (){
		                        location.reload();
		                    });
		            },
		            error:function (){
		                alert("删除失败");
		            }
		        });
			});
		},
};