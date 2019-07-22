package com.citi.javatest.doubletest;

public class DoubleTest {

	/**
	 * 把1000改成1000.00就会完成强制类型转换
	 * */
	public static void main(String[] args) {
//		Integer weight = 2132;
//		System.out.println(weight/1000.00);
		test01();
		Double a = 16.0;
		System.out.println((int)a.doubleValue());
	}
	
	public static void test01() {
		int i = 16;
		if(i%3!=0) {
			
		}
		System.out.println(i/3);
		System.out.println(i%3);
	}

}
