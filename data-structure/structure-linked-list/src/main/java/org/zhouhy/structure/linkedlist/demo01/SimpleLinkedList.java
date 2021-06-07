package org.zhouhy.structure.linkedlist.demo01;

import org.zhouhy.structure.linkedlist.demo01.node.HeroNode;

public class SimpleLinkedList {
    private HeroNode head;
    
    public SimpleLinkedList(){
        this.head = new HeroNode();
    }
    
    public void add(HeroNode heroNode){
        HeroNode temp = this.head;
        while(true){            
            if(temp.getNext()==null){
                temp.setNext(heroNode);
                break;
            }else{
                temp = temp.getNext();
            }
        }
    }
    
    public void list(){
        HeroNode temp = this.head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }
}
