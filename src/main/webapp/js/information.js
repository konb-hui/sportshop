$(document).ready(function(){
    var oldPswflag=0;
    var newPswflag=0;
    var usernameflag = 1;
    var emailflag = 1;
    var phoneflag = 1;
    $("#username").val($("#usernameVal").text());
    $("#email").val($("#emailVal").text());
    $("#phone").val($("#telephoneVal").text());
    $("#changeInfo").click(function(){
        $("#update-info").modal({
            backdrop:'static'
        });
    });
    $("#username").blur(function (){
        if ($("#username").val().length == 0)
        {
        	$("#usernameLabel").html("用户名不能为空！");
        	usernameflag=0;
            $("#usernameError").show();
        }else if($("#username").val().length > 18){
        	$("#usernameLabel").html("用户名不能太长！");
        	usernameflag=0;
            $("#usernameError").show();
        }
        else
        {
            $("#usernameError").hide();
            usernameflag=1;
        }
    })
        $("#email").blur(function (){
        if ($("#email").val().length == 0)
        {
        	$("#emailLabel").html("邮箱不能为空！");
        	emailflag=0;
            $("#emailError").show();
        }else if(!$("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
        	$("#emailLabel").html("邮箱不正确！");
        	emailflag=0;
            $("#emailError").show();
        }
        else
        {
            $("#emailError").hide();
            emailflag=1;
        }
    })
       $("#phone").blur(function (){
        if ($("#phone").val().length == 0)
        {
        	$("#phoneLabel").html("手机号码不能为空！");
        	phoneflag=0;
            $("#phoneError").show();
        }else if($("#phone").val().length != 11){
        	$("#phoneLabel").html("手机号码不正确！");
        	phoneflag=0;
            $("#phoneError").show();
        }
        else
        {
            $("#phoneError").hide();
            phoneflag=1;
        }
    })

    $("#saveInfo").click(function (){
    	if(usernameflag==1 &&emailflag==1 && phoneflag==1){
            var saveInfo={};
            saveInfo.username=$("#username").val();
            saveInfo.email=$("#email").val();
            saveInfo.phone=$("#phone").val();
            $.ajax({
                type: "POST",
                url: "./userAction_update",
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                data:saveInfo,
                dateType:"json",
                success: function(){
                        $("#update-info").modal('hide');
                        swal("修改成功", "", "success");
                        $("button").click(function (){
                            location.reload();
                        });
                },
                error:function (){
                    alert("更新失败");
                }
            });
    	}
    });

    $("#changePsw").click(function (){
        $("#update-Psw").modal({
            backdrop:'static'
        });
    });

    $("#oldPsw").blur(function (){
        if ($("#oldPsw").val()!=$("#Psw").attr("Psw"))
        {
            $("#oldPswError").show();
        }
        else
        {
            $("#oldPswError").hide();
            oldPswflag=1;
        }
    })

   /* $("#newPsw").focus(function (){
        if ($("#oldPsw").val()==$("#Psw").attr("Psw"))
        {
            $("#oldPswError").hide();
            oldPswflag=1;
        }
    });*/

    $("#newPsw").blur(function (){
        if($("#newPsw").val().length<8)
        {
            $("#newPswError").show();
        }
        else {
            $("#newPswError").hide();
            newPswflag=1;
        }
    });

    $("#savePsw").click(function (){
        if (oldPswflag==1&&newPswflag==1)
        {
            var Psw={};
            Psw.password=$("#newPsw").val();
            $.ajax({
                type: "POST",
                url: "./userAction_updatePsw",
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                data:Psw,
                dateType:"json",
                success: function(){
                        $("#update-info").modal('hide');
                        swal("修改成功", "", "success");
                        $("button").click(function (){
                            location.reload();
                        });
                },
                error:function (){
                    alert("更新失败");
                }
            });
        }
    })

});
