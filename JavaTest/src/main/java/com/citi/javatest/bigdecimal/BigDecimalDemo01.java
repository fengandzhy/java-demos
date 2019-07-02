package com.citi.javatest.bigdecimal;

import java.math.BigDecimal;

/**
 * BigDecimal 保留2位小数
 * */
public class BigDecimalDemo01 {
	
	public static void main(String args[]){
		BigDecimal a1 = new BigDecimal(2.623);
		BigDecimal a2 = new BigDecimal(2);
		
		BigDecimal a3 = a1.multiply(a2).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal a4 = a1.divide(a2).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(a3);
		System.out.println(a4);
	}
}
