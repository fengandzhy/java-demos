package com.citi.java8.comparator.demo01;

import java.util.Comparator;
import java.util.List;

public class AgeComparator {
	
	public Comparator<Developer> comparator(List<Developer> list) {
		Comparator<Developer> ageComparator = Comparator.comparing(Developer::getAge);
		return ageComparator;
	}
}
