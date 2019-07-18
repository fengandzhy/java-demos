package com.citi.javatest.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo05 {
	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal(1);
		BigDecimal b2 = new BigDecimal(2);
		BigDecimal b3 = new BigDecimal(3);
		
		System.out.println(b1.add(b2).multiply(b3));
	}
}
