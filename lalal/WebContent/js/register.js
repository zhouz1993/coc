$(function(){
	$("#pwdMsg1").html("字母、数字");
	$("#ok").click(function(){         //注册
		$("#nameMsg1").html("");
		$("#pwdMsg1").html("");
		$("#pwdMsg2").html("");
		var name = $("#username1").val().trim();
		var pwd1 = $("#password1").val().trim();
		var pwd2 = $("#password2").val().trim();
		var flag = true;
		if(name==""){
			$("#nameMsg1").html("不能为空！！");	
			flag = false;
		}
		if(pwd1.length<6){
			$("#pwdMsg1").html("请输入6-18个字符！");
			flag = false;
		}
		if(pwd2!=pwd1){
			$("#pwdMsg2").html("两次输入密码不一致！");
			flag = false;
		}
		if(flag){
		$.ajax({
			url : "regist.do",
			type : "post",
			dataType : "json",
			async : false,
			data:{
				"name":name,"password":pwd1
			},
			success : function(result) {
				if (result.status == 0) {
					alert("注册成功");
					window.location.href="index.jsp";
				}
				if(result.status==1){
					alert("该用户已经存在");
				}
			},
			error:function(){
				alert("注册失败");
			}
		});
		
		}
		
		
	});
	
	
});

function regist(){
	document.getElementById("center").style.visibility="hidden";
	document.getElementById("div_zc").style.visibility="visible";
}

//重置
$(function(){
	$("#reset").click(function(){
		$("#username1").val("");
		$("#password1").val("");
		$("#password2").val("");
	});
});








