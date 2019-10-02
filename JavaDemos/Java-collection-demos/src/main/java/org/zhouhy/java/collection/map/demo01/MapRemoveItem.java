package org.zhouhy.java.collection.map.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapRemoveItem {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		/**
		 * 这种方法删除会报ConcurrentModificationException
		 * */
//		for(Integer key:map.keySet()) {
//			System.out.println(map.get(key));
//			if(key==3) {
//				map.remove(key);
//			}
//		}
		
		/**
		 * 这种方法删除会报ConcurrentModificationException
		 * */
//		Iterator<Integer> iter = map.keySet().iterator();
//		while(iter.hasNext()) {
//			Integer key = iter.next();
//			if(key==3) {
//				map.remove(key);
//			}
//		}
		System.out.println(map.size());
		Iterator<Map.Entry<Integer,String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			if(entry.getKey()==3) {
				iter.remove();
			}
			System.out.println(map.get(entry.getKey()));
		}
		System.out.println(map.size());
	}

}
