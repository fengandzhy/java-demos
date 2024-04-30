package org.frank.collections.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        
//        Map<String, Integer> map = new TreeMap<>((t1,t2)->{
//            return t1.length() - t2.length();
//        }); // 它会按照 key 的长度排名
//        map.put("Bob", 30);
//        map.put("Alice", 25);
//        map.put("Charlie", 20);
//        
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        Map<String, Integer> map = new TreeMap<>();
        map.put("Bob", 30);
        map.put("Alice", 25);
        map.put("Charlie", 20);

        // 创建自定义Comparator，按照值的大小顺序排序
        Comparator<String> comparator = Comparator.comparingInt(map::get);

        // 使用自定义Comparator进行排序
        Map<String, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);

        // 输出排序后的结果
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
