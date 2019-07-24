package com.citi.javatest.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest1 {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(0);
		arrayList.add(2);
		arrayList.add(4);
		
//		for(Integer value:arrayList) {
//			if(value == 0) {
//				arrayList.remove(value);
//			}
//		}
		
//		Iterator<Integer> iterator = arrayList.iterator();
//		while(iterator.hasNext()) {
//			if(iterator.next() == 0) {
//				iterator.remove();
//			}
//		}
		
		arrayList.stream().forEach(arg0->System.out.println(arg0));
	}

}
