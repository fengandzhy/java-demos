package org.zhouhy.java.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsefulUtils {
    
    public static void listToString(){
        List<String> list = Arrays.asList("a","b","c");
        String join = list.stream().collect(Collectors.joining(","));
        System.out.println(join);
        String str = String.join(",",list);
        System.out.println(str);
    }
    
    public static boolean equalsIgnoreCase(String strA,String strB){
        return strA.equalsIgnoreCase(strB);
    }

    public static boolean isEquals(Object objA,Object objB){
        return Objects.equals(objA,objB);
    }

    public static <E> List<E> retainList(List<E> listA,List<E> listB){
        listA.retainAll(listB);
        return listA;
    }

    public static String abbreviate(String str, int maxWidth){
        return StringUtils.abbreviate(str,maxWidth);
    }
}
