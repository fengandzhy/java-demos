package org.zhouhy.javatest.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		
		boolean flag = list1.retainAll(list2);
		System.out.println(flag);
		
	}

}
