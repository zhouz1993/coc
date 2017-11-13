function update() {
	var empno = $("#emp_id").val().trim();
	var ename = $("#emp_name").val().trim();
	var age = $("#emp_age").val().trim();
	var deptno = $("#deptno").val().trim();
	var hiredate = $("#hirdate").val().trim();
	var salary = $("#emp_sal").val().trim();
	// alert(empno+" "+ename+" "+age+" "+deptno+" "+hiredate+" "+salary);

	var flag = true;
	if (isNaN(parseInt(age)) || age > 70 || age < 20) {
		alert("年龄不符合标准");
		flag = false;
	}

	if (flag) {
		$.ajax({
					url : "update.do",
					type : "post",
					// traditional : true,
					data : {
						"empno" : empno,
						"ename" : ename,
						"age" : age,
						"deptno" : deptno,
						"hiredate" : hiredate,
						"salary" : salary
					},
					dataType : "json",
					async : false,
					success : function(result) {
						if (result.status == 0) {
							$(".trb").remove();
							window.location.href="index.jsp";
						//	findAll();
							document.getElementById("modify").style.visibility = "hidden";
							document.getElementById("index1").style.opacity = 1;

						}

					},
					error : function() {
						alert("修改信息失败！！");
					}
				});

	}
}