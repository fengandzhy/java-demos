package org.zhouhy.structure.linkedlist.demo01;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo02.BiDirectionLinkedList;
import org.zhouhy.structure.linkedlist.demo02.node.BiDirectionHeroNode;

import static org.junit.Assert.*;

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

        node = new BiDirectionHeroNode(4,"公孙胜","入云龙");
        biDirectionLinkedList.add(node);
        size = biDirectionLinkedList.size();
        assertEquals(3, size);
    }

    @Test
    public void test2(){
        
        try{
            biDirectionLinkedList.get(0);
            fail("No exception thrown.");
        }catch(Exception ex){
            assertTrue(ex instanceof ArrayIndexOutOfBoundsException);
            assertTrue(ex.getMessage().contains("数组越界"));
        }
        BiDirectionHeroNode node = new BiDirectionHeroNode(2,"卢俊义","玉麒麟");
        biDirectionLinkedList.add(node);
        node = new BiDirectionHeroNode(3,"吴勇","军师");
        biDirectionLinkedList.add(node);
        
        System.out.println(biDirectionLinkedList.get(0));
        System.out.println(biDirectionLinkedList.get(1));

        node = new BiDirectionHeroNode(4,"公孙胜","入云龙");
        biDirectionLinkedList.add(node);

        System.out.println(biDirectionLinkedList.get(2));
    }

    @Test
    public void test3(){        
        BiDirectionHeroNode node = new BiDirectionHeroNode(2,"卢俊义","玉麒麟");
        biDirectionLinkedList.add(node);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");
        node = new BiDirectionHeroNode(3,"吴勇","军师");
        biDirectionLinkedList.add(node);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");
        node = new BiDirectionHeroNode(4,"公孙胜","入云龙");
        biDirectionLinkedList.add(node);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");
        node = new BiDirectionHeroNode(5,"关胜","大刀");
        biDirectionLinkedList.add(node);
        biDirectionLinkedList.list();        
    }

    @Test
    public void test4(){
        BiDirectionHeroNode node = new BiDirectionHeroNode(2,"卢俊义","玉麒麟");
        biDirectionLinkedList.add(node);        
        node = new BiDirectionHeroNode(3,"吴勇","军师");
        biDirectionLinkedList.add(node);
        node = new BiDirectionHeroNode(4,"公孙胜","入云龙");
        biDirectionLinkedList.add(node);        
        node = new BiDirectionHeroNode(5,"关胜","大刀");
        biDirectionLinkedList.add(node);

        biDirectionLinkedList.list();
        System.out.println("-----------------------");
        biDirectionLinkedList.remove(0);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");

        node = new BiDirectionHeroNode(6,"林冲","豹子头");
        biDirectionLinkedList.add(node);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");

        biDirectionLinkedList.remove(3);
        biDirectionLinkedList.list();
        System.out.println("-----------------------");

        biDirectionLinkedList.remove(1);
        biDirectionLinkedList.list();
    }
}
