package com.citi.javatest.map;

import java.util.HashMap;
import java.util.Map;

public class MapInteger {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("a", 0);
		Integer a = map.get("a");
		a =2;
		System.out.println(map.get("a"));//0
	}

}
