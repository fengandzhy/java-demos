package org.zhouhy.java8.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class getLastMondayAndSunday {

	public static void main(String[] args) {
		LocalDate now =LocalDate.now();
		getLastMonday(now);
		getLastSunday(now);
	}
	
	public static void getLastMonday(LocalDate now) {		
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		LocalDate lastMonday = now.minusDays(7+dayOfWeek.getValue()-1);
		System.out.println(lastMonday);
	}
	
	
	public static void getLastSunday(LocalDate now) {		
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		LocalDate lastSunday = now.minusDays(dayOfWeek.getValue());
		System.out.println(lastSunday);
	}
	

}
