package org.zhouhy.structure.linkedlist.demo03;

import org.zhouhy.structure.linkedlist.demo03.node.HeroNode;

public class DoubleLinedList {
    private HeroNode head;
    
    public DoubleLinedList(){
        this.head = new HeroNode();
    }
    
    public boolean isEmpty(){
        return head.getNext()==null;
    }
    
    
    
}
