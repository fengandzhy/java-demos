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

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = this.head;
        boolean isDuplicate = false;
        while(true){
            if(temp.getNext()==null){                
                break;
            }
            if(temp.getNext().getId()>heroNode.getId()){
                break;
            }
            if(temp.getNext().getId() == heroNode.getId()){
                isDuplicate = true;
                break;
            }
            temp = temp.getNext();
        }
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);
    }
    
    public void update(HeroNode node){
        boolean isExists = false;
        HeroNode temp = head;
        while(true){            
            temp = temp.getNext();
            if(temp == null){
                break;
            }
            if(temp.getId().equals(node.getId())){
                isExists = true;
                break;
            }
        }
        if(isExists){
            temp.setName(node.getName());
            temp.setNickname(node.getNickname());
            return;
        }
        System.out.println("没有找到对应节点!");
    }
    
    public void list(){
        HeroNode temp = this.head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }
    
    public boolean isEmpty(){
        return head.getNext() == null;
    }
}
