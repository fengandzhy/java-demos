package org.zhouhy.javatest.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo02 {

	public static void main(String[] args) {
		BigDecimal a1 = new BigDecimal(2.623);
		BigDecimal a2 = new BigDecimal(2);
		System.out.println(a1.subtract(a2));
		System.out.println(a1.subtract(a2).setScale(2,BigDecimal.ROUND_HALF_UP));
	}

}
