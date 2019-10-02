package org.zhouhy.java.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 仅仅是Integer的排序
 * */
public class IntegerListSort {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(69);
		list.add(2);
		
//		for(Integer a :list) {
//			System.out.println(a);
//		}
		
		System.out.println(list.get(3));
		
		Collections.sort(list);
		
		System.out.println(list.get(3));
		
//		for(Integer a :list) {
//			System.out.println(a);
//		}

	}

}
