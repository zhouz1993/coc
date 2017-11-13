var id = "";
var ename = "";
var age = "";
var deptno = "";
var hiredate = "";
var salary = "";

function modifyEmp() {
	if ($("input[name='box']:checked").length == 1) {

		document.getElementById("modify").style.visibility = "visible";
		document.getElementById("index1").style.opacity = 0.3;

		var check = $("input[name='box']:checked").parents("tr");

		id = check.children().eq(1).text();
		ename = check.children().eq(2).text();
		age = check.children().eq(3).text();
		deptno = check.children().eq(4).text();
		hiredate = check.children().eq(5).text();
		salary = check.children().eq(6).text();

		$("#emp_id").val(id);
		$("#emp_name").val(ename);
		$("#emp_age").val(age);
		$("#deptno").val(deptno);
		$("#hirdate").val(hiredate);
		$("#emp_sal").val(salary);
	} else if ($("input[name='box']:checked").length > 1) {
		alert("执行此操作只能选择一项！！！");
	} else {
		alert("请选择你要修改的一项！！");
	}

}