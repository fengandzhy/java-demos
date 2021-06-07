package org.zhouhy.structure.linkedlist.demo01;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo01.node.HeroNode;

public class SimpleLinkedListTest {
    
    private SimpleLinkedList linkedList;
    
    @Before
    public void setUp(){
        this.linkedList = new SimpleLinkedList();
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
    }
    
    @Test
    public void test1(){
        linkedList.list();
    }
}
