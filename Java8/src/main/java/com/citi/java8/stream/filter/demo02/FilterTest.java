package com.citi.java8.stream.filter.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");
        
        List<String> interestion = list1.stream().filter(item->list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        interestion.stream().forEach(System.out::println);
        
	}
}
