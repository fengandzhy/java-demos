package org.zhouhy.java.java8.stream.groupby;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDemos {	
	
	public void groupBy1(List<Student> list1) {
		Map<String,List<Student>> map = list1.stream().collect(Collectors.groupingBy(t->t.getName()));
		for(Map.Entry<String,List<Student>> entry:map.entrySet()) {
			System.out.println(entry.getKey()+entry.getValue());
		}
	}
	
	public void groupBy2(List<Student> list1) {
		list1.stream().collect(Collectors.groupingBy(Student::getName))
		.forEach((name,students)->{
			System.out.println(name+" "+students);
		});		
	}
	
	public void groupBy3(List<Student> list1) {
		Map<String,Long> result2=list1.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
		for(Map.Entry<String,Long> entry:result2.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}		
	}
}
