package org.zhouhy.java8.localdate;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class getLastDayAndFirstOfLastMonth {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		getLastDayOfLastMonth(today);
		getFirstDayofLastMonth(today);
	}
	
	public static void getLastDayOfLastMonth(LocalDate today) {
		LocalDate lastDay = today.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDay);		
	}
	
	public static void getFirstDayofLastMonth(LocalDate today) {
		LocalDate firstDay = today.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDay);
	}

}
