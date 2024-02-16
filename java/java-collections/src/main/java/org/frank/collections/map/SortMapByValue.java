package org.frank.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
public class SortMapByValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 3);
        map.put("Peach", 7);
        map.put("Pear", 6);

        // 根据value 进行排序, 得到一个新的 Map.Entry<String,Integer> 类型的 list
        List<Map.Entry<String,Integer>> list = map.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // 把这个 Map.Entry<String,Integer> 类型的list ，并收集到一个新的LinkedHashMap中
        LinkedHashMap<String,Integer> linkedHashMap = list.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2) -> e1, // 如果有值相同key，选择第一个
                        LinkedHashMap::new // 指定存储的map类型 
                )); // 因为 LinkedHashMap 是保证插入顺序的,所以 这里用LinkedHashMap
        linkedHashMap.forEach((key,value) -> {System.out.println(key+":"+value);});
    }
}
