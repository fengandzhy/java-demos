package org.zhouhy.structure.linkedlist.demo03;

import org.zhouhy.structure.linkedlist.demo03.node.HeroNode;

public class DoubleLinekdList {
    private HeroNode head;
    
    public DoubleLinekdList(){
        this.head = new HeroNode();
    }
    
    public boolean isEmpty(){
        return head.getNext()==null;
    }
    
    public void add(HeroNode node){
        HeroNode tempNode = head;
        while(true){
            if(tempNode.getNext()==null){
                break;
            }
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(node);
        node.setPrevious(tempNode);
    }
    
    public int size(){
        int size = 0;
        if(this.isEmpty()){
            return size;
        }
        HeroNode tempNode = head.getNext();
        while(true){
            size++;
            if(tempNode.getNext() == null){
                break;
            }
            tempNode = tempNode.getNext();
        }
        return size;
    }
    
}
