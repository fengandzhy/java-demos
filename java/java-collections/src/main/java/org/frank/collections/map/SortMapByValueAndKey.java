package org.frank.collections.map;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValueAndKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 10);
        map.put("Mango", 20);
        map.put("Grape", 10);


//        List<Map.Entry<String, Integer>> sortedEntries = map.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue()
//                        .thenComparing(Map.Entry.comparingByKey()))
//                .collect(Collectors.toList());

        List<Map.Entry<String, Integer>> sortedEntries = map.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toList());
        
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.forEach((key,value) -> {System.out.println(key+":"+value);});
    }
}
