package org.zhouhy.corejava.ch03;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String name = scanner.nextLine();
		
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		//注意这里要加个括号，否则就变成字符串相加了
		System.out.println("Hello "+name+" next year you will be "+(age+1));
		
		scanner.close();
	}

}
