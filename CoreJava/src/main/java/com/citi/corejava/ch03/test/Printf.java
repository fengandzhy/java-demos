package com.citi.corejava.ch03.test;

public class Printf {

	public static void main(String[] args) {
		 /*** 输出字符串 ***/

        // %s表示输出字符串，也就是将后面的字符串替换模式中的%s
        System.out.printf("%s", new Integer(1212));

        // %n表示换行
        System.out.printf("%s%n", "end line");

        // 还可以支持多个参数
        System.out.printf("%s = %s%n", "Name", "Zhangsan");

        // %S将字符串以大写形式输出
        System.out.printf("%S = %s%n", "Name", "Zhangsan");

        // 支持多个参数时，可以在%s之间插入变量编号，1$表示第一个字符串，3$表示第3个字符串
        System.out.printf("%1$s = %3$s %2$s%n", "Name", "san", "Zhang");

        
	
	}

}
