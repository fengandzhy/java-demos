package com.citi.javatest.map;

import java.util.HashMap;
import java.util.Map;

public class MapInteger {

	/**
	 * Integer是final类型的，所以一经指定就不会再变
	 * 
	 * */
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("a", 0);
		Integer a = map.get("a");
		a =2;
		System.out.println(map.get("a"));//0
	}

}
