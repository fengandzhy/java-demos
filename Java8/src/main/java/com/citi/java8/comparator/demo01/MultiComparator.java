package com.citi.java8.comparator.demo01;

import java.util.Comparator;
import java.util.List;

public class MultiComparator {

	
	public Comparator<Developer> comparator(List<Developer> list) {
		Comparator<Developer> multiComparator = Comparator.comparing(Developer::getSalary)
				.thenComparing(Developer::getName);		
		return multiComparator;
	}
	
	/**
	 * 先根据工资排序再根据名字倒序
	 * 第一个reversed()表示第一个字段倒序
	 * 第二个reversed()表示第二个字段之前的所有字段(也就是说包含第一个字段)倒序
	 * 这样一来，第一个字段,倒序之后再倒序，变成正序,第二个字段由于只倒序一次就成倒序
	 * 这样就实现了先按工资正序排序再根据名字倒序排列 
	 * */
	public Comparator<Developer> comparator1(List<Developer> list) {
		Comparator<Developer> multiComparator = Comparator.comparing(Developer::getSalary).reversed()
				.thenComparing(Developer::getName).reversed();		
		return multiComparator;
	}
}
