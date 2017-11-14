function searchEmp(){
	var se = $("#txt").val().trim();
	var flag = true;
	if(se.length>0){
	$(".trb").remove();
	$(".setr").remove();
	}else{
		alert("请输入所要查询的内容！！");
	//	window.location.href = "index.jsp";
		flag = false;
	}
    //alert(se);
	if(flag){
	if(isNaN(parseInt(se))){
		$.ajax({
			url : "searchBNm.do",
			type : "post",
		//	traditional : true,
			data : {
				"name" :se,
			},
			dataType : "json",
			async : false,
			success : function(result) {
			//	alert(result.status);
				if (result.status == 0) {				
					
					var em = result.data;
					for (var i = 0; i < em.length; i++) {
						var empno = em[i].empno;
						var ename = em[i].ename;
						var age = em[i].age;
						var deptno = em[i].deptno;
						var hiredate = em[i].hiredate;
						var salary = em[i].salary;
						var str = "<tr name='tr' class='setr' >";                // 拼接table
						str += "<td><input type='checkbox' name='box' /></td>";
						str += "<td >" + empno + "</td>";
						str += "<td >" + ename + "</td>";
						str += "<td >" + age + "</td>";
						str += "<td >" + deptno + "</td>";
						str += "<td >" + hiredate + "</td>";
						str += "<td >" + salary + "</td>";
						str += "</tr>";
						$('#tb').append(str);          //将拼接好的 tr 加入到tbody 中
					}
				//	window.location.href = "index.jsp";
				}else{
				//	findAll();
					alert(result.message);
				}

			},
			error : function() {
				alert("查询失败！！");
			}
		});
		
	}else{
		$.ajax({
			url : "search.do",
			type : "post",
		//	traditional : true,
			data : {
				"id" :se,
			},
			dataType : "json",
			async : false,
			success : function(result) {
			//	alert(result.status);
				if (result.status == 0) {				
					
					var em = result.data;
					for (var i = 0; i < em.length; i++) {
						var empno = em[i].empno;
						var ename = em[i].ename;
						var age = em[i].age;
						var deptno = em[i].deptno;
						var hiredate = em[i].hiredate;
						var salary = em[i].salary;
						var str = "<tr name='tr' class='setr' >";                // 拼接table
						str += "<td><input type='checkbox' name='box' /></td>";
						str += "<td >" + empno + "</td>";
						str += "<td >" + ename + "</td>";
						str += "<td >" + age + "</td>";
						str += "<td >" + deptno + "</td>";
						str += "<td >" + hiredate + "</td>";
						str += "<td >" + salary + "</td>";
						str += "</tr>";
						$('#tb').append(str);          //将拼接好的 tr 加入到tbody 中
					}
				//	window.location.href = "index.jsp";
				}else if(result.status==1){
				//	findAll();
					alert(result.message);
				}else{
					alert(result.message);
				}

			},
			error : function() {
				alert("查询失败！！");
			}
		});
	}
	
	}
	
	
	
	
}