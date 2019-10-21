package org.zhouhy.java.java8.localtime;

import java.time.LocalTime;

public class LocalTimeTest {

	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.toString());
		
		LocalTime newTime = localTime.plusHours(2); 
		System.out.println(newTime);
	}

}
