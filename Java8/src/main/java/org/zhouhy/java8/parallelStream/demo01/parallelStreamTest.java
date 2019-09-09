package org.zhouhy.java8.parallelStream.demo01;

import java.util.Arrays;
import java.util.List;

public class parallelStreamTest {
	
	public static void main(String args[]) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.parallelStream()
		       .forEach(System.out::println); 
	}
}
