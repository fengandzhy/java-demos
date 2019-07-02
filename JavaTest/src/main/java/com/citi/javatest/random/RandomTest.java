package com.citi.javatest.random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomTest {
	
	/**
	 * 返回5个不同的随机数
	 * */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		random1(5, set);
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
	}
	
	public static void random1(int n, Set<Integer> set) {
		for(int i=0;i<n;i++) {
			int num = (int)(Math.random()*(100000-10000)+10000);
			set.add(num);
		}		
		int setSize = set.size();		
		if(setSize<n) {
			random1(n-setSize,set);
		}
		
	}
	
	
}
