package org.frank.java17;

import java.util.Map;

/**
 * 使用Map.ofEntries方法创建的映射是完全不可修改的。
 * 这意味着一旦创建，你不能添加、删除或修改映射中的元素。如果尝试修改这个映射，将抛出UnsupportedOperationException。
 * 
 * Map.ofEntries创建的映射不允许使用null作为键或值。尝试使用null键或值将抛出NullPointerException。
 * */
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
