package com.citi.corejava.ch03.test;

import java.util.stream.IntStream;

public class StringAPI {

	public static void main(String[] args) {
		String greeting = "Hello";
		codePoints(greeting);
		
	}
	
	public static void codePoints(String str) {
		IntStream is = str.codePoints();
		System.out.println(is.count());
	}
}
