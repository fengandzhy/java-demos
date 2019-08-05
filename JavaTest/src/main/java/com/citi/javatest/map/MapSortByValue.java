package com.citi.javatest.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {

	public static void main(String[] args) {
		Map<Integer,Double> map = new HashMap<>();
		map.put(1, 1.0);
		map.put(2, 2.0);
		map.put(3, 3.0);
		map.put(4, 4.0);
		
		
		List<Map.Entry<Integer, Double>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		
		list = map.entrySet().stream()
			      .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
			      .collect(Collectors.toList());
		
//		list.sort(new Comparator<Map.Entry<Integer, Double>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//
		for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
	}

}
