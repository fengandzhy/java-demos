package org.frank.java17;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 局部变量类型推断的例子
 * */
public class TypeInferenceExample {
    public static void main(String[] args) {
        var list = new ArrayList<String>(); // 推断为 ArrayList<String>
        list.add("Hello");
        list.add("World");
        
        var map = new HashMap<String,Integer>();
        map.put("Sam",7);
        map.put("William",5);
        
        for(var entry: map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
