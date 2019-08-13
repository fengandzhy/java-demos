package com.citi.java7.chap04.demos;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatNumberToCurrency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字");
		double data = sc.nextDouble();
		System.out.println("该数字用Locale类的以下常量作为格式化对象的构造参数，将获得不同的货币格式：");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println("Locale.CHINA：" + nf.format(data));
		
		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US：" + nf.format(data));
		
		nf = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		System.out.println("Locale.TAIWAN：" + nf.format(data));
		
		nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
		System.out.println("Locale.CANADA：" + nf.format(data));
		
	}

}
