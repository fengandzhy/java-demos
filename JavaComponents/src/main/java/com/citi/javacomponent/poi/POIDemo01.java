package com.citi.javacomponent.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class POIDemo01 {
	
	private static final String EXCEL_XLS = "xls";  
    private static final String EXCEL_XLSX = "xlsx";  
	private static Connection connection;
    
	public static void main(String args[]) throws IOException, SQLException {
		if(connection==null) {
			initConnection();
		}
		List<String[]> items = readFile();
		Iterator<String[]> iterator = items.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'toothbrush',2,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);		
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);
			//pStatement.setString(2, str[1]);
			pStatement.executeUpdate();
		}
		System.out.println("Success");
	}
	
	public static List<String[]> readFile() throws IOException{
		File excelFile = new File("d:/a.xlsx"); // 创建文件对象
		FileInputStream in = new FileInputStream(excelFile); // 文件流
		Workbook workbook = getWorkbok(in,excelFile);			
		Sheet sheet = workbook.getSheet("特殊规则");
		
		int count = 0;
		List<String[]> list = new ArrayList<>();
		for(Row row : sheet) {
			if(count==0) {
				count++;
				continue;
			}			
			String[] str = new String[3];
			Cell cell1 = row.getCell(0);
//			Cell cell2 = row.getCell(1);			
			str[0] = cell1.getStringCellValue();
//			str[1] = cell2.getStringCellValue();
			if(str[0]==null || str[0].length()==0) {
				break;
			}
//			str[0] = cell1.getNumericCellValue()+"";
//			Cell cell2  = row.getCell(4);
//			str[1] = cell2.getNumericCellValue()+"";
//			Cell cell3  = row.getCell(5);
//			cell3.setCellType(Cell.CELL_TYPE_STRING);
//			str[2]=cell3.getStringCellValue();
			list.add(str);
			count++;
			System.out.println(count);
		}
		return list;
	}
	
	public static void insertDB(List<String[]> items){
		
	}
	
	private static Workbook getWorkbok(InputStream in,File file) throws IOException{		
		if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003 
			return new HSSFWorkbook(in); 
		}		
		return new XSSFWorkbook(in); 
	}
	
	private static void initConnection() throws SQLException {
		
		String urlString = "jdbc:mysql://localhost:3306/nzh1";
		BasicDataSource dataSouce = new BasicDataSource();
		dataSouce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSouce.setUrl(urlString);
		dataSouce.setUsername("root");
		dataSouce.setPassword("root");
		dataSouce.setInitialSize(5);
		dataSouce.setMaxActive(20);
		connection = dataSouce.getConnection();
				
	}
}
