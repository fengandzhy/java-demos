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
    
    /**
     * 执行完s1后，内存中会有两个对象，一个在方法区中的常量池，一个在堆内存，地址值是不一样的，s1指向的是堆内存中的对象，
     * 当执行到s2时，s2指向的是方法区常量池中的对象。地址值不一样，==比较为false，String类重写equals方法，比较的值，故true
     * */
    @Test
    public void equalTest2(){
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
    }

    /**
     * Java中有常量优化机制，“a”、“b”、“c”本身就是字符串常量，所以在编译时，“a”+“b”+"c"就是“abc”字符串，
     * 所以就在常量池创建了“abc”字符串，当执行s2的时候，此时常量池中已经存在了“abc”，所以==号比较返回true。equals方法比较毫无疑问是true。
     * */
    @Test
    public void equalTest3(){
        String s1 = "a"+"b"+"c";
        String s2 = "abc";
        System.out.println(s1 == s2); // true
    }

    /**
     * s1+"c"中s1不是常量，涉及到变量相加，所以会生成新的对象，其内部实现是先new一个StringBuilder/StringBuffer，
     * 然后 append(s1)；append(“c”);然后让s3引用toString()返回的这个对象。
     * s3指向堆内存中的对象，s2是方法区常量池中的对象，故为false；
     * */
    @Test
    public void equalTest4(){
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2); // false
        System.out.println(s3.equals(s2)); // true
    }
}
