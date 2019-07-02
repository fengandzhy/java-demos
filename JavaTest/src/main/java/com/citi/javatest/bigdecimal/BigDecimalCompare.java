package com.citi.javatest.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalCompare {
	
	public static void main(String args[]) {
		BigDecimal d = new BigDecimal("10.0022");  
        BigDecimal e = new BigDecimal("10.002200000000000000000000");
        BigDecimal f = new BigDecimal(new Integer(10));
        BigDecimal g = new BigDecimal(String.valueOf(10.002200000000000000000000));
        
        System.out.println(String.valueOf(e.doubleValue()));
        
        System.out.println(e.equals(d)); //false  
        System.out.println(e.toPlainString().equals(d.toPlainString())); //false  
        System.out.println(e.longValue() == d.longValue()); //true  
        System.out.println(e.doubleValue() == d.doubleValue()); //true  
        System.out.println(e.compareTo(d) == 0); //false
        System.out.println(f.compareTo(e) == 0); //false
        
        System.out.println(e);
        System.out.println(f); 
        System.out.println(g); 
	}
}
