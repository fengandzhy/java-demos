package org.frank.basic.str;

import org.junit.Test;

public class StringTest {
    
    /**
     * String字符串属于常量，常量需要进入内存中的字符串常量池（进入常量池规则：如果常量池中没有这个常量，就创建一个，如果有就不再创建了），
     * 所以s2的引用也指向内存区中已经存在的“123”，所以地址一样，==对于引用类型比较的是地址，String类和其他基本类型的封装类中重写了equals方法，
     * 比较的是值。
     * */
    @Test
    public void equalTest1(){
        String s1 = "123";
        String s2 = "123";
        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true
    }
    
    
}
