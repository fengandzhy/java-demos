package com.citi.javacomponent.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PopulateRules {
	private static Connection connection;
	
	public static void main(String args[]) throws IOException, SQLException {
		//populateRMP();
		//populateToothBrush();
		//populateLipstick();
		//populateCloth();
		//populateEoaron();
		//populateQuilt();
		//populateGift();
		//populateMask();
		//populateVolumn();
		populateCourier();
	}
	
	//牙刷
	public static void populateToothBrush() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("toothbrush");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'toothbrush',2,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("toothbrush Success");
		connection.close();
		
	}
	
	//口红
	public static void populateLipstick() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("lipstick");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'lipstick',4,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("lipstick Success");		
	}
	
	//衣物
	public static void populateCloth() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("cloth");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'cloth',5,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("cloth Success");		
	}
	
	//水光针
	public static void populateEoaron() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("eoaron");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'eoaron',3,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("eoaron Success");		
	}
	
	
	//被子
	public static void populateQuilt() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("quilt");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'quilt',1,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("quilt Success");		
	}
	
	//礼品
	public static void populateGift() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("gift");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'gift',1,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("gift Success");		
	}
	
	//面膜
	public static void populateMask() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("categoryquantity");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'categoryquantity',10,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);			
			pStatement.executeUpdate();
		}
		System.out.println("categoryquantity Success");		
	}
	
	//体积
	public static void populateVolumn() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("volumn");		
		List<String[]> list = readFile(sheet,1);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'volumn',?,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);
			pStatement.setString(2, str[1]);
			pStatement.executeUpdate();
		}
		System.out.println("volumn Success");		
	}
	
	//快递公司
	public static void populateCourier() throws IOException, SQLException {
		if(connection==null||connection.isClosed()) {
			initConnection();
		}
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("courier");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,courier_id,prod_sku,limit_type,max_value,description)"
				+" values(1,1,?,'courier',0,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);		
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);
			pStatement.executeUpdate();
		}
		System.out.println("courier Success");
	}
	
	//RMP
	public static void populateRMP() throws IOException, SQLException {
		Workbook workbook = getWorkbok();			
		Sheet sheet = workbook.getSheet("PMP");		
		List<String[]> list = readFile(sheet,0);
		Iterator<String[]> iterator = list.iterator();
		String sql = "insert into t_separate_rules(warehouse_id,prod_sku,limit_type,max_value,description)"
				+" values(1,?,'forbidden',0,'mianmo')";
		PreparedStatement pStatement = connection.prepareStatement(sql);		
		while(iterator.hasNext()) {
			String[] str = iterator.next();
			pStatement.setString(1, str[0]);
			pStatement.executeUpdate();
		}
		System.out.println("PMP Success");
	}
	
	public static List<String[]> readFile(Sheet sheet,int sign) {
		String sheetName = sheet.getSheetName();
		System.out.println(sheetName);
		List<String[]> list = new ArrayList<>();
		int count = 0;
		for(Row row : sheet) {
			if(count==0) {
				count++;
				continue;
			}
			String[] str = new String[3];
			Cell cell0 = row.getCell(0);
			str[0] = cell0.getStringCellValue();
			if(sign==1) {
				Cell cell1 = row.getCell(1);
				str[1] = cell1.getStringCellValue();
			}
			if(str[0]==null || str[0].length()==0) {
				break;
			}			
			list.add(str);
			count++;
		}
		return list;
	}
	
	
	private static Workbook getWorkbok() throws IOException{		
		File file = new File("d:/a.xlsx"); // 创建文件对象
		FileInputStream in = new FileInputStream(file); // 文件流
		if(file.getName().endsWith("xls")){  //Excel 2003 
			return new HSSFWorkbook(in); 
		}		
		return new XSSFWorkbook(in); 
	}
	
	@SuppressWarnings("unused")
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
