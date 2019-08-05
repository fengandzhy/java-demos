package com.citi.corejava.ch03.test;

import java.util.Scanner;

/**
 * 验证next()与nextLine()的区别
 * next只是读取到结束符前的内容，而nextLine()读取的是
 * */
public class ScannerTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		System.out.println(next);
		int a = scanner.nextInt();
		System.out.println(a);
		double d = scanner.nextDouble();
		System.out.println(d);
		String str = scanner.nextLine();
		System.out.println(str);
		double e = scanner.nextDouble();
		System.out.println(e);		
		scanner.close();
	}

}
