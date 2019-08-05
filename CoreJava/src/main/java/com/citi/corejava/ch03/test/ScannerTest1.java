package com.citi.corejava.ch03.test;

import java.util.Scanner;

/**
 * 验证next()与nextLine()的区别
 * next只是读取到结束符前的内容，而nextLine()读取的是回车键前所有的没有被赋值的内容
 * 例如本例，输入wew 12 12.3 werwe,那么nextLine()读取的就是werwe,因为前三个已经被赋值了
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
