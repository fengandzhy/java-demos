package org.zhouhy.structure.linkedlist;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.structure.linkedlist.demo01.SimpleLinkedList;
import org.zhouhy.structure.linkedlist.demo01.node.HeroNode;

import static org.junit.Assert.assertTrue;

public class SimpleLinkedListTest {
    
    private SimpleLinkedList linkedList;
    
    @Before
    public void setUp(){
        this.linkedList = new SimpleLinkedList();
        
    }
    
    @Test
    public void test1(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.list();
    }

    @Test
    public void test2(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        linkedList.list();
    }

    @Test
    public void test3(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        HeroNode node5 = new HeroNode(1,"宋江2","及时雨2");
        linkedList.update(node5);
        linkedList.list();
    }

    @Test
    public void test4(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        linkedList.delById(5);
        //linkedList.list();
        System.out.println(linkedList.size());
        System.out.println("*********************************");
        linkedList.delById(1);
        //linkedList.list();
        System.out.println(linkedList.size());
    }

    @Test
    public void test5(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        HeroNode node = linkedList.get(4);
        assertTrue(null == node);
        node = linkedList.get(3);
        System.out.println(node);        
    }

    @Test
    public void test6(){
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
        HeroNode node5 = new HeroNode(5,"关胜","大刀");
        HeroNode node6 = new HeroNode(6,"林冲","豹子头");
        HeroNode node7 = new HeroNode(7,"秦明","霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼","双鞭");
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node8);
        linkedList.addByOrder(node7);
        linkedList.addByOrder(node6);
        linkedList.addByOrder(node5);
        
        linkedList.list();
        System.out.println("*************************");
        linkedList.reverse();
        linkedList.list();
        
    }
}
