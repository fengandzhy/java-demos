package org.frank.java.util;

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
    
    
    /**
     * 
     * */
    public static void abbreviateMiddle(){
        String str2 = StringUtils.abbreviateMiddle("15889009897","****",9);
        System.out.println(str2); //158****97
        //字符刚好只有10个
        String s1 = StringUtils.abbreviateMiddle("134235453as4", "**", 10);
        System.out.println(s1); //1342354534
        //截取5个字符
        String s2 = StringUtils.abbreviateMiddle("12345678910", "***", 5);
        System.out.println(s2); //12*10
        //截取长度不能小于2
        String s3 = StringUtils.abbreviateMiddle("12345678910", "*", 4);
        System.out.println(s3); //12345678910
    } 
}
