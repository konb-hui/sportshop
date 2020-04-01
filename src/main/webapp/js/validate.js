
$.validator.setDefaults({
	submitHandler: function() {
		form.submit();
	}
});
$(document).ready(function() {
	$('#form').validate({
		rules: {
			account:{
				required:true,
				minlength:6,
				maxlength:18,
			},
			username: {
				required:true,
				maxlength:18,
			},
			sex: {
				required:true,
			},
            phone: {
            	minlength:11,
            	maxlength:11,
            	digits:true,
				required: true,
			},
            email: {
				required: true,
				email: true,
			},
            password: {
				required: true,
				minlength: 8,
				maxlength:18,
			},
			confirmPassword: {
				required: true,
				minlength: 8,
				equalTo: "#password",
			}
		},
		messages: {
			account:{
				required:"账号不能为空",
				minlength:"账号的长度太短",
			    maxlength:"账号的长度太长",
			},
            username: {
            	required:"用户名不能为空",
            	maxlength:"用户名太长"
            },
            sex: {
            	required:"必须选择性别",
            },
            phone: {
            	required:"联系电话不能为空",
            	minlength:"输入的电话号码不合法",
            	maxlength:"输入的电话号码不合法",
            	digits:"输入的电话号码不合法",
            },
            email: {
				required: "邮箱输入不能为空",
				email: "请输入一个正确的邮箱",
			},
            password: {
				required: "密码输入不能为空",
				minlength: "密码长度不能小于8位",
				maxlength: "密码太长",
			},
			confirmPassword: {
				required: "输入不能为空",
				minlength: "密码长度不能小于8位",
				equalTo: "两次密码输入不一致",
			}
		}
	});
});