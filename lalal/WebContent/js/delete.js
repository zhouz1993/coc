$(document).ready(function() {
	$("input[name='delete']").click(function() {
		// alert("12321");
		// var tr = $("#cb").parent().parent();
		// var id = tr.children().eq(1).val();
		// var tr = $("input[name='box']:checked").parents("tr");

		// var length =
		// document.getElementById('tb').getElementsByTagName('tr').length;
		// alert(length);
		var flag = true;	
		if ($("input[name='box']:checked").length<1) {
			alert("执行此操作至少选择一项");
			flag=false;
		}
		if (flag) {
			var arr = new Array();
			$("input[name='box']:checked").each(function() {
				var tr = $(this).parents("tr"); // this?
				var id = tr.children().eq(1).text();
				// alert(id);
				arr.push(id);
			});

			// alert(arr.toString());
		//	alert("确定要删除选中记录？");
			var r=confirm("确定要删除选中记录？？");      //页面弹出有 确认和取消，点击确认返回boolean为true,取消返回false;
			console.log(r);
			if(!r){
				window.location.href="index.jsp";
			}else{
			$.ajax({
				url : "delete.do",
				type : "post",
				traditional : true, // 这个设置为true，data:{"arr":["102","103","104"]}会转换成arr=102&arr=103&arr=104...
				data : {
					"arr" : arr
				},
				dataType : "json",
				success : function(result) {
					if (result.status == 0) {
						//alert(result.message);
						alert("删除成功！！");
						window.location.href = "index.jsp";
					}
				},
				error : function() {
					alert("删除失败");
				}
			});			

			}
			
			
			
		}

	});
});

   //    全选      <input type='checkbox' id='box2' onclick="checkAll(this.checked)"/>全选
function checkAll(checked){
	 //根据名字获取所有checkbox控件
	   var allCheckBoxs=document.getElementsByName("box") ;
	   //循环设置控件为选中状态
	   for (var i=0;i<allCheckBoxs.length ;i++){
	       if(allCheckBoxs[i].type=="checkbox"){
	              allCheckBoxs[i].checked=checked;
	       }
	    } 
}









