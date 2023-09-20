package org.frank.basic.number;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberTest {
    
    @Test
    public void numberTest1(){
        int i = 1;
        int j = i++ + 1; // 先取值再自增
        assertTrue(j == 2);        
    }

    
    @Test
    public void numberTest2(){
        int i = 1;
        int j = ++i + 1; // 先自增再取值.
        assertTrue(j == 3);
    }
}
