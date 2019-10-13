package org.zhouhy.java.poi.excel.generate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class GenerateExcelFile {
	
	private static final String FILE_NAME = "\\sales.xls";
	
	public void sample1() throws Exception {
		
		//创建一个工作簿workbook
		Workbook workbook = new HSSFWorkbook();		
		
		//创建一个工作表sheet
		Sheet sheet = workbook.createSheet("aaaa");
		
		//创建一个行对象row（下标起始值为0），这里是第4行
		Row row = sheet.createRow(3);
		
		//创建一个单元格对象cell（下标起始值为0），这里是第四列
		Cell cell = row.createCell(3);
		
		//设置单元格的内容
		cell.setCellValue("My home town");
		
		
		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Microsoft YaHei UI");
		font.setFontHeightInPoints((short)40);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
		
		OutputStream os = new FileOutputStream("D:\\excel测试.xls");
		workbook.write(os);
		os.close();
		workbook.close();
	}
	
	@SuppressWarnings("resource")
	public void sample2() throws Exception {
		String filePath = System.getProperty("user.dir");
		String path = filePath+FILE_NAME;
		File excelFile = new File(path);
		HSSFWorkbook workbook;
		if(excelFile.exists()) {
			workbook = new HSSFWorkbook(new FileInputStream(excelFile));
		}else {
			workbook = new HSSFWorkbook();
		}
		
		Sheet sheet = workbook.createSheet("bbbbdddd");
		
		Row row = sheet.createRow(3);
		
		Cell cell = row.createCell(3);
		
		cell.setCellValue("My home town");
		
		
		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Microsoft YaHei UI");
		font.setFontHeightInPoints((short)40);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
		
		OutputStream os = new FileOutputStream(filePath+FILE_NAME);
		workbook.write(os);
		os.close();
		workbook.close();		
	}
	
	public void sample3() throws Exception {
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
	}
}
