package org.frank.java17;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream.toList()返回的List是不可修改的。任何试图修改这个List的操作都会抛出UnsupportedOperationException。
 * 这个方法提供了一种快速、简洁的方式来从Stream生成List，特别适合那些不需要修改返回的List的场景。
 * 使用Stream.toList()可以减少对Collectors类的直接依赖，使得代码看起来更加简洁。
 * 
 * Stream.of("a","b","c").collect(Collectors.toList()); 这种方法得到的list 是可变的
 * 
 * */
public class StreamEnhancementExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a","b","c");
        List<String> list = stream.toList();
//        list.add("d"); // 这个list 不可变, 任何试图修改这个List的操作都会抛出UnsupportedOperationException
        System.out.println(list);

        List<String> list1 = Stream.of("a","b","c").collect(Collectors.toList());
        list1.add("d");
        System.out.println(list1);
    }
}
