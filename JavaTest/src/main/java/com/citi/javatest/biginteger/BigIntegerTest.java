package com.citi.javatest.biginteger;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 3;
		
		BigDecimal abigd = new BigDecimal(a);
		System.out.println(a.doubleValue()/b);
		System.out.println(new BigDecimal(a).divide(new BigDecimal(b),4,BigDecimal.ROUND_HALF_UP ));

	}

}
