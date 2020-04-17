var UserManage = {
		changeSex:function(){
			$('#sex').change(function(){
				var sex = $(this).children('option:selected').val();
				if(sex != "1"){
					window.location.href = "userAction_userManage?sex=" + sex;
				}
			});
		},
		searchForName:function(){
			$('#search').click(function(){
				var username = $('#username').val();
				if(username != ""){
					 var sex = $('#sex').children('option:selected').val();
					 if(sex != 1){
						 window.location.href = "userAction_userManage?sex=" + sex + "&username=" + username;
					 }else{
						 window.location.href = "userAction_userManage?username=" + username;
					 }
				}
			});
		},
};