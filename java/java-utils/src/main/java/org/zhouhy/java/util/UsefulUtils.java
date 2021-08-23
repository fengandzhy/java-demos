package org.zhouhy.java.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsefulUtils {
    
    public static void listToString(){
        List<String> list = Arrays.asList("a","b","c");
        String join = list.stream().collect(Collectors.joining(","));
        System.out.println(join);
        String str = String.join(",",list);
        System.out.println(str);
    }
    
    
}
