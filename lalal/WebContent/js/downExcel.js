$(document).ready(function() {
	$("input[name='excel']").click(function() {
		$.ajax({
			url : "downExcel.do",
			type : "post",
			// data:null,
			dataType : "json",
			async : false,
			success : function() {
				
			}
		// error:function(){

		// }
		});
	});
});