package com.wis.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.wis.DAO.EmppDAO;
import com.wis.entity.Empp;


@Service("outputExcel")
public class OutputExcelImpl implements OutputExcel {
	public static final String[] header = {"empno","ename","age","deptno","hiredate","salary"};
	
	@Resource
	private EmppDAO emppDAO;
	@Override
	public void outpExcel() throws IOException {
	//	System.out.println("outpExcel");
		List<Empp> list;
		try {
			list = emppDAO.findAll();
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("员工信息表");
			
			//设置表头
			Row row1 = sheet.createRow(0);
			//设置行高
			row1.setHeight((short) (20*20));
			//设置字体
			Font font = null;  
			CellStyle style = null; 
			font = wb.createFont();  
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
			style = wb.createCellStyle();  
			style.setFont(font);
			
			for(int j=0;j<header.length;j++){
			//	System.out.println("hah");
				Cell cell = row1.createCell(j);
				cell.setCellStyle(style);
				cell.setCellValue(header[j]);
			}
			//输出数据
			for (int i = 0; i < list.size(); i++) {
				Row row = sheet.createRow(i + 1);
				Empp emp = list.get(i);
			//	System.out.println("hehe");
				row.createCell(0).setCellValue(emp.getEmpno());
				row.createCell(1).setCellValue(emp.getEname());
				row.createCell(2).setCellValue(emp.getAge());
				row.createCell(3).setCellValue(emp.getDeptno());
				row.createCell(4).setCellValue(emp.getHiredate());
				row.createCell(5).setCellValue(emp.getSalary());
			}
			//	wb.setSheetName(0, "first sheet");
			
			FileOutputStream file = new FileOutputStream("D:\\demo4.xlsx");
			wb.write(file);
			file.close();
			System.out.println("导出表数据成功！！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
