package com.citi.javatest.string;

public class StringTest01 {

	public static void main(String[] args) {
		String string = "EWR201907231840284367_12345";
		System.out.println(string.substring(string.length()-5));
		System.out.println(string.substring(0,string.length()-5));
	}
}
