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
				var key = $('#key').val();
				if(key.trim() != ""){
					window.location.href = "userAction_searchByKey?key=" + key;
				}
			});
		},
};