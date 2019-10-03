package org.zhouhy.java8.localdate;

import java.time.LocalDate;

public class LocalDateTest {

	public static void main(String[] args) {
		addDate();
	}
	
	
	
	public static void addDate() {
		System.out.println("加法运算");  
		System.out.println("当前：" + LocalDate.now());  
		System.out.println("加1天：" + LocalDate.now().plusDays(1));  
		System.out.println("加1周：" + LocalDate.now().plusWeeks(1));  
		System.out.println("加1月：" + LocalDate.now().plusMonths(1));  
		System.out.println("加1年：" + LocalDate.now().plusYears(1));
		
		System.out.println("减法运算");  
		System.out.println("当前：" + LocalDate.now());  
		System.out.println("减1天：" + LocalDate.now().minusDays(1));  
		System.out.println("减1周：" + LocalDate.now().minusWeeks(1));  
		System.out.println("减1月：" + LocalDate.now().minusMonths(1));  
		System.out.println("减1年：" + LocalDate.now().minusYears(1));
		
		
		System.out.println("当前：" + LocalDate.now());  
		System.out.println("替换日期为1：" + LocalDate.now().withDayOfMonth(1));  
		System.out.println("替换天数为1：" + LocalDate.now().withDayOfYear(1));  
		System.out.println("替换月份为1：" + LocalDate.now().withMonth(1));  
		System.out.println("替换年份为1：" + LocalDate.now().withYear(1));  
	}

}
