package org.zhouhy.java.collection.map.demo02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		Collection<String> a = map.values();
		for(String str:a) {
			System.out.println(str);
		}
	}

}
