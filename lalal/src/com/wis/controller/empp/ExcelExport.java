package com.wis.controller.empp;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wis.util.FileDownLoadUtil;
import com.wis.util.OutputExcel;

@Controller
public class ExcelExport {
	
	@Resource(name="outputExcel")
	private OutputExcel excel;
	
	@RequestMapping("/downExcel.do")
	public void exportExcel() throws FileNotFoundException, IOException{
		excel.outpExcel();
	}
	
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response){
		
		FileDownLoadUtil.fileDownload(response, "D:/Tomcat/apache-tomcat-8.0.9/wtpwebapps/lalal/image/qq.zip", "shuibian.zip");
	}
}
