<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Token</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
	function download(){
		$.ajax({
			url:"..//download.do",
			type:"post",
			responseType: 'arraybuffer',
			success : function(data, status, headers, config) {
			//	alert(headers);
			//	var fileName = 's';//headers('Content-Disposition').split("=")[1];
	                
				var blob = new Blob([ data ], {type : "application/zip"});
			/* 	if (1) {
					blob = new Blob([ data ],{type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
				} else {
					blob = new Blob([ data ], {type : "application/zip"});
				} */

				/* if (window.navigator.msSaveOrOpenBlob) {// For IE:
					navigator.msSaveBlob(blob, fileName);
				} else { // For other browsers:
					var objectUrl = URL.createObjectURL(blob);
					var a = document.createElement('a');
					document.body.appendChild(a);
					a.setAttribute('style', 'display:none');
					a.setAttribute('href', objectUrl);
					a.setAttribute('download', fileName);
					a.click();
					URL.revokeObjectURL(objectUrl);
					// window.open(objectUrl);
				} */

			},
			error : function() {
				alert("下载失败！");
			}
		});
	}
</script>
</head>
<body>
	<input type="button"  onclick="download()" id="save" value="download"/> 
</body>
</html>