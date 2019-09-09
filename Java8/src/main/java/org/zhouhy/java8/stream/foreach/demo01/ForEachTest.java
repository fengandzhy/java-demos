package org.zhouhy.java8.stream.foreach.demo01;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(1);
		
		list.stream().forEach(t->{System.out.println(t+1);
		System.out.println(t);});

	}

}
