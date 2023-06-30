package org.frank.java.object;

import org.junit.Test;

/**
 * 1. String str = “abc”;可能创建一个或者不创建对象，如果”abc”在字符串池中不存在，
 * 会在java字符串池中创建一个String对象（”abc”），然后str指向这个内存地址，无论以后用这种方式创建多少个值为”abc”的字符串对象，
 * 始终只有一个内存地址被分配。
 * 
 * 2. String str = new String(“abc”);至少会创建一个对象，也有可能创建两个。
 * 因为用到new关键字，肯定会在堆中创建一个String对象，如果字符池中已经存在”abc”,则不会在字符串池中创建一个String对象，
 * 如果不存在，则会在字符串常量池中也创建一个对象。
 * 
 * 
 * */
public class StringTest {
    
    @Test
    public void test1(){
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str2==str1); //true
    }

    @Test
    public void test2(){
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str2==str1); //false
        String str3 = "abc";
        System.out.println(str3 == str1);//false
        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();
    }
}
