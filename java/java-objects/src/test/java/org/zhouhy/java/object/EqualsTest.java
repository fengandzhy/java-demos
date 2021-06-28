package org.zhouhy.java.object;

import org.junit.Test;

import java.util.Objects;

/**
 * 1. a.equlas(b); 如果a是null, 则会抛出NullPointerException, 所以用Objects.equals(Object a, Object b) 
 * 
 * */
public class EqualsTest {
    
    @Test
    public void Test1(){        
        System.out.println(Objects.equals(null,"abc"));
        System.out.println(Objects.equals(null,null));
        System.out.println(Objects.equals("abc",null));
    }
}
