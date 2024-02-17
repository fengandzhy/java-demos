package org.frank.java17;

import java.util.Map;

public class MapOfEntriesExample {
    public static void main(String[] args) {
        Map<String,Integer> map = Map.ofEntries(
                Map.entry("a", 1), 
                Map.entry("b", 2),
                Map.entry("c", 3)
        );
        System.out.println(map);
    }
}
