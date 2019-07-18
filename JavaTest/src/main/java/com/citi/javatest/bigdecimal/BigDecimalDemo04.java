package com.citi.javatest.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo04 {

	public static void main(String[] args) {
		Integer totalweight = 300;
		Integer itemweight = 100;
		
		System.out.println((double)itemweight/totalweight);
		
		BigDecimal b1 = new BigDecimal(10.24);
		BigDecimal b2 = b1.multiply(new BigDecimal((double)itemweight/totalweight)).setScale(2,BigDecimal.ROUND_HALF_UP);
		
		System.out.println(b2);
	}
}
