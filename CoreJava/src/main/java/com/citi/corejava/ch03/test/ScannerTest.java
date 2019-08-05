package com.citi.corejava.ch03.test;

import java.util.Scanner;

/**
 * 循环输入直到两个回车结束
 * */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		while(true) {			
			String str = scanner.nextLine();
			System.out.println(str);			
						
			if(str.length()==0) {
				if(flag) {
					break;
				}else {
					flag=true;
				}
			}else {
				flag = false;
			}
		}		
		scanner.close();
	}

}
