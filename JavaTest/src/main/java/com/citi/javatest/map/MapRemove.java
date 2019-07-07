package com.citi.javatest.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapRemove {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("a", 2);
		map.put("b", 1);
		map.put("c", 3);
		map.put("d", 4);
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		
		for(String str:list) {
			if(map.containsKey(str)) {
				map.remove(str);
			}
		}
		
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
