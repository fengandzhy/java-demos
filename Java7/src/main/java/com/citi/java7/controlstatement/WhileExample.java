package com.citi.java7.controlstatement;

import java.math.BigDecimal;

/**
 * 036
 * Êä³ö1+1/2!+1/3!...1/20!
 * */
public class WhileExample {
	
	public static void main(String args[]) {
		method1();
		method2();
	}
	
	public static void method1() {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal fraction = new BigDecimal(0);
		int index =1;
		while(index<=20) {
			BigDecimal demominator = new BigDecimal(1);
			for(int i=index;i>1;i--) {
				demominator = demominator.multiply(new BigDecimal(i));
			}
			fraction = new BigDecimal(1).divide(demominator,4,BigDecimal.ROUND_HALF_UP);
			sum = sum.add(fraction);			
			index++;
		}
		
		System.out.println("The result for 1+1/2!+1/3!...1/20! is "+sum);
	}
	
	public static void method2() {
		BigDecimal sum = new BigDecimal(0.0);
		BigDecimal fractorial = new BigDecimal(1.0);
		int i=1;
		while(i<=20) {
			sum = sum.add(fractorial);
			++i;
			fractorial = fractorial.multiply(new BigDecimal(1.0/i));
		}		
		System.out.println("The result for 1+1/2!+1/3!...1/20! is "+sum.setScale(4,BigDecimal.ROUND_HALF_UP));		
	}
	
}
