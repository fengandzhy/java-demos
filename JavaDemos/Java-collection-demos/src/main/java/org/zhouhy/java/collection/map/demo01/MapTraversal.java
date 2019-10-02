package org.zhouhy.java.collection.map.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTraversal {
	
	public static void main(String[] args){
		
		
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"a");
		map.put(2,"b");
		map.put(3,"c");
		
//		traversalMethod1(map);
		traversalMethod2(map);
//		traversalMethod3(map);
		
//		traversalMethod4(map);		
	}
	
	public static void traversalMethod1(Map<Integer, String> map) {
		for(Map.Entry<Integer, String>entry : map.entrySet()) {
			System.out.println("key="+entry.getKey()+" value="+entry.getValue());
		}
	}
	
	public static void traversalMethod2(Map<Integer, String> map) {
		for(Integer key: map.keySet()) {
			System.out.println("key="+key);
		}
		
		for(String value:map.values()) {
			System.out.println("value = " + value); 
		}
	}
	
	public static void traversalMethod3(Map<Integer, String> map) {
		Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println("key="+entry.getKey()+" value="+entry.getValue());
		}
	}
	
	public static void traversalMethod4(Map<Integer, String> map) {
		Iterator<Integer> iterator1 = map.keySet().iterator();
		while(iterator1.hasNext()) {
			System.out.println("key="+iterator1.next());
		}
		
		Iterator<String> iterator2 = map.values().iterator();
		while(iterator2.hasNext()) {
			System.out.println("value = " + iterator2.next()); 
		}
	}
}
