package com.citi.javatest.bigdecimal.demo01;

import java.math.BigDecimal;

public class BigDecimalCompare {
	
	public static void main(String args[]) {
		BigDecimal d = new BigDecimal("10.0022");  
        BigDecimal e = new BigDecimal(10.0022);
        
        System.out.println(e.equals(d)); //false  
        System.out.println(e.toPlainString().equals(d.toPlainString())); //false  
        System.out.println(e.longValue() == d.longValue()); //true  
        System.out.println(e.doubleValue() == d.doubleValue()); //true  
        System.out.println(e.compareTo(d) == 0); //false  
	}
}
