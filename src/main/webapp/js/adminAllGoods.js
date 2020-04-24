var adminAllGoods = {
	updateGood:function(){
		var gid;
		var gname;
		var price;
		var vipPrice;
		var cid;
		var bid;
		$("[name='update']").click(function(){
	        $("#update-good").modal({
	            backdrop:'static'
	        });
	        $("#updategid").text($(this).parent().siblings("#gid").text());
	        $("#updategname").val($(this).parent().siblings("#gname").text());
	        $("#updateprice").val($(this).parent().siblings("#price").text());
	        $("#updatevipPrice").val($(this).parent().siblings("#vipPrice").text());
	        $("#updatecategory").val($(this).parent().parent().find("#gcategoryid").val());
	        $("#updatebrand").val($(this).parent().parent().find("#gbrandid").val());
	        gid = $(this).parent().siblings("#gid").text();
		});
		$("#saveUpdate").click(function(){
			gname = $("#updategname").val();
			price = $("#updateprice").val();
			vipPrice = $("#updatevipPrice").val();
			cid = $("#updatecategory").val();
			bid = $("#updatebrand").val();
	        $.ajax({
		        url: "goodAction_updateGood",
		        type: "post",
		        data: {
		        	gid:gid,
		        	gname:gname,
		        	price:price,
		        	vipPrice:vipPrice,
		        	cid:cid,
		        	bid:bid,
		        },
	            success: function(result){
	                if (result!="更新成功")
	                {
	                    swal(result);
	                }
	                else {
	                    $("#update-good").modal('hide');
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
	addGood:function(){
		$('#add').click(function(){
			 $("#add-good").modal({
		            backdrop:'static'
		        });
				$("#saveAdd").click(function(){
					var gname = $('#addgname').val();
					var price = $('#addprice').val();
					var vipPrice = $('#addvipPrice').val();
					var bid = $('#addbrand').val();
					var cid = $('#addcategory').val();
			        $.ajax({
				        url: "goodAction_addGood",
				        type: "post",
				        data: {
				        	gname:gname,
				        	price:price,
				        	vipPrice:vipPrice,
				        	bid:bid,
				        	cid:cid,
				        },
			            success: function(result){
			                if (result!="添加成功")
			                {
			                    swal(result);
			                }
			                else {
			                    $("#update-good").modal('hide');
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
	deleteGood:function(){
		$("[name='delete']").click(function(){
			var gid = $(this).parent().siblings('#gid').text();
			if(window.confirm("您确认要删除吗?")){
			    $.ajax({
			        url: "goodAction_deleteGood",
			        type: "post",
			        data: {
			        	gid:gid
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
	changecategory:function(){
		$("#changecategory").change(function(){
			var cid = $(this).val();
			var bid = $("#changebrand").val();
			if(cid != "选择"){
				if(bid != "选择"){
					window.location.href = $("body").data("url") + "?cid=" + cid + "&bid=" + bid;
				}else{
					window.location.href = $("body").data("url") + "?cid=" + cid;
				}
			}else{
				window.location.href = $("body").data("url");
			}
		});
	},
	changebrand:function(){
		$("#changebrand").change(function(){
			var bid = $(this).val();
			var cid = $("#changecategory").val();
			if(bid != "选择"){
				if(cid != "选择"){
					window.location.href = $("body").data("url") + "?cid=" + cid + "&bid=" + bid;
				}else{
					window.location.href = $("body").data("url") + "?bid=" + bid;
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