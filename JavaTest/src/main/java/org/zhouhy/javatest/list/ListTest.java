package org.zhouhy.javatest.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one Two three Four five six one three Four".split(" "));
		System.out.println(list);
		System.out.println("最大值: " + Collections.max(list));
		System.out.println("最小值: " + Collections.min(list));
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(3);
		intList.add(6);
		intList.add(8);
		intList.add(10);
		
		System.out.println("最大值: " + Collections.max(intList));
		System.out.println("最小值: " + Collections.min(intList));
	}

}
