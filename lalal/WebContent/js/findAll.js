//页面加载时 执行此操作。。。
function findAll() {
	$.ajax({ // 发送Ajax jeson
		url : "empp.do", // 请求地址
		type : "post", // 请求方式
		// data:null,
		dataType : "json", // 返回类型 后端用ResponseBody
		async : false,
		success : function(result) { // 成功之后的会掉函数，返回一个封装状态
			if (result.status == 0) {
				var em = result.data;
				for (var i = 0; i < em.length; i++) {
					var empno = em[i].empno;
					var ename = em[i].ename;
					var age = em[i].age;
					if (age == null) {
						age = "";
					}
					var deptno = em[i].deptno;
					if (deptno == null) {
						deptno = "";
					}
					var hiredate = em[i].hiredate;
					var salary = em[i].salary;
					if (salary == null) {
						salary = "0.0";
					}
					var str = "<tr name='tr' class='trb'>"; // 拼接table
					str += "<td><input type='checkbox' name='box' class='chox'/></td>";
					str += "<td >" + empno + "</td>";
					str += "<td >" + ename + "</td>";
					str += "<td >" + age + "</td>";
					str += "<td >" + deptno + "</td>";
					str += "<td >" + hiredate + "</td>";
					str += "<td >" + salary + "</td>";
					str += "</tr>";
					$('#tb').append(str); // 将拼接好的 tr 加入到tbody 中
				}

			}

		}
	});

}

