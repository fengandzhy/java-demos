package org.zhouhy.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastClassTest {
    private CastClass castClass;
    
    @Before
    public void setUp(){
        castClass = new CastClass();
    }
    
    @Test
    public void test1(){
        Object x = "abc";
        String x2 = this.castClass.get(String.class,x);
        assertEquals(x2,"abc");
    }
}
