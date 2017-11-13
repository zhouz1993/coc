$(function() {
	$("#sub").click(function() {
		$("#nameMsg").html("");
		$("#pwdMsg").html("");
		
		var name = $("#username").val().trim();
		var pwd = $("#password").val().trim();

		var ischeck = true;
		if (name == "") {
			$("#nameMsg").html("用户名不能为空");
			ischeck = false;
		}
		if (pwd == "") {
			$("#pwdMsg").html("密码不能为空");
			ischeck = false;
		}

		if (ischeck) {

			$.ajax({
				url : "login.do",
				type : "post",
				data : {
					"username" : name,
					"password" : pwd
				},
				dataType : "json",
				success : function(result) {

					if (result.status == 0) {
						// var id = result.data;
						window.location.href = "index.jsp";
						// alert(result.data.name);
					} else if (result.status == 1) {
						$("#nameMsg").html("账号不存在！");
						$("#nameMsg").css("color","red");
					} else {
						$("#pwdMsg").html("密码错误！");
						$("#pwdMsg").css("color","red");
					}
				},
				error : function() {
					alert("登陆失败");
				}
			});
		}
	});
});