package com.citi.javatest.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo03 {

	
	/**
	 * BigDecimal a3 = a1.divide(a2).setScale(2, BigDecimal.ROUND_HALF_UP);
	   *  这样运算会报错
	 * */
	public static void main(String[] args) {
		BigDecimal a1 = new BigDecimal(2);
		BigDecimal a2 = new BigDecimal(3);
		
//		BigDecimal a3 = a1.divide(a2).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal a3 = a1.divide(a2, 4, BigDecimal.ROUND_HALF_UP);
		System.out.println(a3);
	}

}
