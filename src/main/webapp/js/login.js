
$.validator.setDefaults({
	submitHandler: function() {
		form.submit();
	}
});
$(document).ready(function() {
	$('#form2').validate({
		rules: {
			username: "required",
			
			password: {
				required: true,
			},
			confirmlogo: {
				required:true,
				minlength:4,
				maxlength:4,
			},
		},
		messages: {
			username: "用户名输入不能为空",
			
			password: {
				required: "密码输入不能为空",
			},
			confirmlogo: {
				required:"验证码输入不能为空",
				minlength:"验证码不对1",
				maxlength:"验证码不对2",
			}
		}
	});
});