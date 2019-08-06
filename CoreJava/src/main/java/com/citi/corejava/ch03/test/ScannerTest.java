package com.citi.corejava.ch03.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 循环输入直到两个回车结束
 * */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		List<String> strList = new ArrayList<>();
		while(true) {			
			String str = scanner.nextLine();									
			if(null==str || str.length()==0) {
				break;
			}
			strList.add(str);
		}		
		scanner.close();
		System.out.println(strList.size());
	}

}
