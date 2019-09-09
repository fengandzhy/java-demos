package org.zhouhy.java8.comparator.demo01;

import java.util.Comparator;
import java.util.List;

public class SalaryComparator {
	public Comparator<Developer> comparator(List<Developer> list) {
		Comparator<Developer> ageComparator = Comparator.comparing(Developer::getSalary);
		return ageComparator;
	}
}
