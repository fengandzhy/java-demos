package com.citi.javatest.integertest;

public class IntegerTest {

	public static void main(String[] args) {
		System.out.println(getNumber(16,3));
		System.out.println(getNumber(87,10));
		
		Integer a = 1;
		Integer b = 1;
		
		System.out.println(a.equals(b));
	}
	
	private static Integer getNumber(Integer prodCount,Integer stardand){
        if(prodCount%stardand!=0){
            return prodCount/stardand+1;
        }
        return prodCount/stardand;
    }

}
