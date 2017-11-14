var pageSize = 5;//每页显示的记录条数
 var curPage=0;   //首页
 var lastPage;		
 var direct=0;		//下一页 or 上一页
 var len;		//table 中数据条数
 var page;      //页数
 
 $(document).ready(function(){  
	 findAll();
     len =$("#tb tr").length;
        page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
    //    alert("page==="+page);
        curPage=1;
        displayPage(1);//显示第一页
        $("#btn1").click(function(){
         curPage=1;
         displayPage();
     });
        $("#btn2").click(function(){
         direct=-1;
         displayPage();
     });
        $("#btn3").click(function(){
         direct=1;
         displayPage();
     });
        $("#btn4").click(function(){
         curPage=page;
         displayPage();
     });
        $("#btn5").click(function(){
        	curPage = document.getElementById("pageNum").value * 1;
        //	alert(pagenum);
        	if (!/^[1-9]\d*$/.test(curPage)) {
				alert("请输入正整数");
				return;
			}
			if (curPage > page) {
				alert("超出数据页面");
				return;
			}
			direct = 0;
			displayPage();
        });
 });
 
 function displayPage(){
	 if (curPage <= 1 && direct == -1) {
			direct = 0;
			alert("已经是第一页了");
			return;
		} else if (curPage >= page && direct == 1) {
			direct = 0;
			alert("已经是最后一页了");
			return;
		}
	 
  lastPage = curPage;
  
  curPage = (curPage + direct + len) % len;
     var begin=(curPage-1)*pageSize;//起始记录号
     var end = begin + pageSize;
  if(end > len ) 
	  end=len;
     $("#tb tr").hide();
     $("#tb tr").each(function(i){
         if(i>=begin && i<end)   //显示第page页的记录
             $(this).show();
     });

 }