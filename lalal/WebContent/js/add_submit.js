function saveEmp() {
	//将数据库中的员工编号存入数组中
	var arr = new Array();
	$.ajax({
		url : "empp.do",
		type : "post",
		dataType : "json",
		async : false,
		success : function(result) {
			if (result.status == 0) {
				var em = result.data;
				for (var i = 0; i < em.length; i++) {
					var empno = em[i].empno;
					arr.push(empno);
				}
			}
		}
	});

	// alert("yes");
	var empno = $("#empno").val().trim();
	var ename = $("#ename").val().trim();
	var age = $("#age").val().trim();
	var deptno = $("#deptno").val().trim();
	var hiredate = $("#hiredate").val().trim();
	var salary = $("#salary").val().trim();

	var flag = true;

	$("#empMsg").html("");
	$("#nameMsg").html("");
	if (empno == "") {
		$("#empMsg").html("编号不能为空");
		 $("#empMsg").css("color","red");
		flag = false;
	}
	if (ename == "") {
		$("#nameMsg").html("姓名不能为空");
		 $("#nameMsg").css("color","red");
		flag = false;
	}

	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == empno) {
			$("#empMsg").html("员工编号不能相同");
			 $("#empMsg").css("color","red");
			flag = false;
			break;
		}
	}
	
	if (isNaN(parseInt(age)) || age > 70 || age < 20) {
		$("#ageMsg").html("年龄不符合标准");
		flag = false;
	}

	if (flag) {
		$.ajax({
			url : "add.do",
			type : "post",
			// data:$('#f1').serialize(),
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
					window.location.href = "index.jsp";
				}

			},
			error : function() {
				alert("添加员工失败！！");
			}
		});
	}

}
