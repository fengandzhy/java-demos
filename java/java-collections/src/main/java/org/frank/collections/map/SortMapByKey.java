package org.frank.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKey {
    
    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 3);
        map.put("Peach", 7);
        map.put("Pear", 6);
        
        List<Map.Entry<String,Integer>> list = map.entrySet()
                .stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        LinkedHashMap<String,Integer> sortedMap = list.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2) -> e1,
                        LinkedHashMap::new
                ));
        sortedMap.forEach((key, value) -> {
            System.out.println(key+":"+value);
        });
                
    }
}
