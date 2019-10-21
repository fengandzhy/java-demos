package org.zhouhy.javabasic.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("abc", 1);		
		map.getOrDefault("abc", null);		
		System.out.println(map.getOrDefault("abc", 0));
	}

}
