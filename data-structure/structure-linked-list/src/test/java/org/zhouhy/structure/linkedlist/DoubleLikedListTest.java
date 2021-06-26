package org.zhouhy.structure.linkedlist;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo03.DoubleLinkedList;

import static org.junit.Assert.assertEquals;

public class DoubleLikedListTest {
    
    private DoubleLinkedList doubleLinkedList;
    
    @Before
    public void setUp(){
        this.doubleLinkedList = new DoubleLinkedList();
    }

    @Test
    public void test1(){
        int size = doubleLinkedList.size();
        assertEquals(0, size);
        
    }
}
