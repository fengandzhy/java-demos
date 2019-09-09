package org.zhouhy.java8.stream.filter.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FilterTest {

	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		Person p1 = new Person(1,"aa","bb");
		Person p2 = new Person(1,"cc","dd");
		Person p3 = new Person(1,"ee","ff");
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		Person p = pList.stream().filter(person->person.getName().equals("aa")).findFirst().orElse(null);
		Stream<Person> stream = pList.stream();

        Stream<Person> stream1 = stream.filter(rule->rule.getName().equals("aa"));

        Optional<Person> option = stream1.findFirst();
		
		System.out.println(p);
	}

}
