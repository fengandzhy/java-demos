package org.zhouhy.java.java8.localdate;

import java.time.LocalDate;

public class SpecificDate {

	public static void main(String[] args) {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth); 
		
		int year = dateOfBirth.getYear(); 
		int month = dateOfBirth.getMonthValue(); 
		int day = dateOfBirth.getDayOfMonth();
		
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day); 
	}

}
