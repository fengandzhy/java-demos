package org.zhouhy.structure.linkedlist.demo01;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo02.BiDirectionLinkedList;
import org.zhouhy.structure.linkedlist.demo02.node.BiDirectionHeroNode;

import static org.junit.Assert.assertEquals;

public class BiDirectionLinkedListTest {
    
    private BiDirectionLinkedList biDirectionLinkedList;
    
    @Before
    public void setUp(){
        biDirectionLinkedList = new BiDirectionLinkedList();
    }
    
    @Test
    public void test1(){
        int size = biDirectionLinkedList.size();
        assertEquals(0, size);
        BiDirectionHeroNode node = new BiDirectionHeroNode(2,"卢俊义","玉麒麟");
        biDirectionLinkedList.add(node);
        size = biDirectionLinkedList.size();
        assertEquals(1, size);
        node = new BiDirectionHeroNode(3,"吴勇","军师");
        biDirectionLinkedList.add(node);
        size = biDirectionLinkedList.size();
        assertEquals(2, size);
    }
    
    
}
