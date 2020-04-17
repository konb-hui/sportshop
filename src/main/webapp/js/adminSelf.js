var adminSelf = {
	updateSelf:function(){
		var adminName;
		var trueName;
		var phone;
		var email;
		$("#changeInfo").click(function(){
	        $("#update-self").modal({
	            backdrop:'static'
	        });
	        $("#updateadminName").val($("#adminNameVal").text());
	        $("#updatetrueName").val($("#trueNameVal").text());
	        $("#updatephone").val($("#phoneVal").text());
	        $("#updateemail").val($("#emailVal").text());
		});
		$("#saveUpdate").click(function(){
			adminName = $("#updateadminName").val();
			trueName = $("#updatetrueName").val();
			phone = $("#updatephone").val();
			email = $("#updateemail").val();
	        $.ajax({
		        url: "adminAction_updateSelf",
		        type: "post",
		        data: {
		        	adminName:adminName,
		        	trueName:trueName,
		        	phone:phone,
		        	email:email,
		        },
	            success: function(result){
	                    $("#update-self").modal('hide');
	                    swal("修改成功", "", "success");
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
	updatePsw:function(){
	    var oldPswflag=0;
	    var newPswflag=0;
	    var sameNewPswflag=0;

	    $("#changePsw").click(function (){
	        $("#update-psw").modal({
	            backdrop:'static'
	        });
	    });

	    $("#oldPsw").blur(function (){
	        if ($("#oldPsw").val().trim()=="")
	        {
	            $("#oldPswError").show();
	        }
	        else
	        {
	            $("#oldPswError").hide();
	            oldPswflag=1;
	        }
	    })

	    $("#newPsw").blur(function (){
	        if($("#newPsw").val().length<6)
	        {
	            $("#newPswError").show();
	        }
	        else {
	            $("#newPswError").hide();
	            newPswflag=1;
	        }
	    });
	    $("#sameNewPsw").blur(function(){
	    	if($("#sameNewPsw").val() != $("#newPsw").val()){
	    		$("#sameNewPswError").show();
	    	}else{
	    		$("#sameNewPswError").hide();
	    		sameNewPswflag=1;
	    	}
	    });
	    $("#saveUpdatePsw").click(function (){
	        if (oldPswflag==1&&newPswflag==1&&sameNewPswflag==1)
	        {
	            var newPsw=$("#newPsw").val();
	            var oldPsw=$("#oldPsw").val();
	            $.ajax({
	                type: "POST",
	                url: "adminAction_updatePsw",
	                contentType:"application/x-www-form-urlencoded; charset=utf-8",
	                data:{
	                	newPsw:newPsw,
	                	oldPsw:oldPsw,
	                },
	                dateType:"json",
	                success: function(result){
	                	if(result == "更新成功"){
	                        $("#update-info").modal('hide');
	                        swal("修改成功", "", "success");
	                        $("button").click(function (){
	                            location.reload();
	                        });
	                	}else{
	                		swal(result);
	                	}
	                },
	                error:function (){
	                    alert("更新失败");
	                }
	            });
	        }
	    });
	},
};