package com.citi.javatest.dowhile;

public class DoWhileDemo {

	public static void main(String[] args) {
		boolean flag = true;
		do {
			for(int i=0;i<100;i++) {
				if(i==10) {					
					break;
				}
				System.out.println(i);
			}
		}while(flag);

	}

}
