package com.citi.java8.comparator.demo01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		Developer dev1 = new Developer("Sam",100.00,25);
		Developer dev2 = new Developer("Tim",200.00,28);
		Developer dev3 = new Developer("Jim",250.00,27);
		Developer dev4 = new Developer("Willian",50.00,21);
		Developer dev5 = new Developer("Hong",50.00,22);
		
		List<Developer> dList = new ArrayList<>();
		dList.add(dev1);
		dList.add(dev2);
		dList.add(dev3);
		dList.add(dev4);
		dList.add(dev5);
		
		Comparator<Developer> ageComparator = new AgeComparator().comparator(dList);
		dList.sort(ageComparator);
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		System.out.println("==============================================================");
		
		dList.sort(ageComparator.reversed());
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		System.out.println("==============================================================");
		
		Comparator<Developer> salaryComparator =new SalaryComparator().comparator(dList);
		dList.sort(salaryComparator);
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		System.out.println("==============================================================");		
		
		dList.sort(salaryComparator.reversed());
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		System.out.println("==============================================================");		
		
		Comparator<Developer> multiComparator =new MultiComparator().comparator(dList);
		dList.sort(multiComparator);
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		System.out.println("==============================================================");		
		dList.sort((o1,o2)->{
			if(o1.getSalary()==o2.getSalary()) {
				return o2.getName().compareTo(o1.getName());
			}
			if(o1.getSalary()>o2.getSalary()) {
				return 1;
			}			
			return -1;
		});
		
		dList.stream().forEach(e->System.out.println(e.getName()+","+e.getSalary()+","+e.getAge()));
		System.out.println(dList.get(0).getName());
		
		
	}
}
