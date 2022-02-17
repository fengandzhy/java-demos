package org.zhouhy.structure.linkedlist.demo01;

import org.zhouhy.structure.linkedlist.demo01.node.HeroNode;

import java.util.Objects;

public class SimpleLinkedList {
    private final HeroNode head;
    
    public SimpleLinkedList(){
        this.head = new HeroNode();
    }
    
    //随意增加
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

    //有序增加
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
            if(Objects.equals(temp.getNext().getId(), heroNode.getId())){
                isDuplicate = true;
                break;
            }
            temp = temp.getNext();
        }
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);
    }
    
    //修改
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
    
    //遍历
    public void list(){
        HeroNode temp = this.head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }
    
    //根据ID来删除
    public void delById(Integer id){
        HeroNode currentNode = findById(id);
        if(null!=currentNode){
            HeroNode previousNode = findPreviousNode(currentNode);
            previousNode.setNext(currentNode.getNext());            
        }else{
            System.out.println("无此节点!");
        }
        
    }
    
    //根据index来查到
    public HeroNode get(int index){
        if(this.size()>index && index >=0){
            int i = -1;
            HeroNode temp = head;
            while(true){
                temp = temp.getNext();
                i++;
                if(i == index){
                   break; 
                }
            }
            return temp;
        }
        return null;
    }
    
    //大小
    public int size(){
        int size =0;
        if(this.isEmpty()){
            return size;
        }
        HeroNode temp = head;
        do {
            temp = temp.getNext();
            size++;
        } while (temp.getNext() != null);
        return size;
    }
    
    public void reverse(){
        int size = this.size();
        HeroNode[] tempNodes = new HeroNode[size];
        for(int i=0;i<size;i++){
            tempNodes[i] = this.get(size-1-i);
        }
        head.setNext(null);
        for(int i=0;i<size;i++){
            tempNodes[i].setNext(null);
            this.add(tempNodes[i]);
        }
    }

    public boolean isEmpty(){
        return head.getNext() == null;
    }
    
    //根据ID来查找
    private HeroNode findById(Integer id){
        HeroNode temp = head;
        while(true){
            temp = temp.getNext();
            if(temp == null){
                break;
            }
            if(temp.getId().equals(id)){
                break;
            }
        }
        return temp;        
    }

    //查找之前的节点
    private HeroNode findPreviousNode(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.getNext()==null){
                temp = null;
                break;
            }
            if(temp.getNext().getId()==heroNode.getId()){
                break;
            }
            temp = temp.getNext();
        }
        return  temp;
    }    
}
