package org.frank.java.objects;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1. 用before 和 after 可以来判断两个对象的日期是否相等
 * 
 * 2. StringBuilder和StringBuffer有共同的父类AbstractStringBuilder. 
 * StringBuffer:是线程安全的(对调用方法加入同步锁),执行效率较慢,适用于多线程下操作字符串缓冲区大量数据.
 * StringBuilder:是线程不安全的,适用于单线程下操作字符串缓冲区大量数据.
 * 
 * */
public class DateTest {
    
    @Test
    public void compareTwoDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String x1 = "2018-06-05 10:02";
        String x2 = "2018-06-05 10:08";

        Date date1 = sdf.parse(x1);
        Date date2 = sdf.parse(x2);

        System.out.println(date1.getTime() > date2.getTime());

        System.out.println(date1.before(date2));

        System.out.println(date1.after(date2));
        
        Double.toString(3.22);

        System.out.println(date1.compareTo(date2));

        System.out.println(Double.toString(3.22));
        
        StringBuffer sb = new StringBuffer();
    }
}
