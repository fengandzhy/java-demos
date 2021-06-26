package org.zhouhy.structure.linkedlist;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo03.DoubleLinkedList;
import org.zhouhy.structure.linkedlist.demo03.node.HeroNode;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

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
        HeroNode node = new HeroNode(1,"宋江","及时雨");
        doubleLinkedList.add(node);
        size = doubleLinkedList.size();
        assertEquals(1, size);

        node = new HeroNode(2,"卢俊义","玉麒麟");
        doubleLinkedList.add(node);
        size = doubleLinkedList.size();
        assertEquals(2, size);

        node = new HeroNode(3,"吴用","智多星");
        doubleLinkedList.add(node);
        size = doubleLinkedList.size();
        assertEquals(3, size);
        
        doubleLinkedList.list();
    }

    @Test
    public void test2(){
        int size = doubleLinkedList.size();
        assertEquals(0, size);
        HeroNode node = new HeroNode(1,"宋江","及时雨");
        doubleLinkedList.add(node);
        node = new HeroNode(2,"卢俊义","玉麒麟");
        doubleLinkedList.add(node);
        node = new HeroNode(3,"吴用","智多星");
        doubleLinkedList.add(node);

        try{
            doubleLinkedList.get(3);
            fail("No exception thrown.");
        }catch(Exception ex){
            assertTrue(ex instanceof ArrayIndexOutOfBoundsException);
            assertTrue(ex.getMessage().contains("数组越界"));
        }

        HeroNode result = doubleLinkedList.get(1);
        assertEquals("卢俊义", result.getName());
    }
}
