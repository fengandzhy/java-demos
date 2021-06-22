package org.zhouhy.structure.linkedlist.demo02;

import org.zhouhy.structure.linkedlist.demo02.node.BiDirectionHeroNode;

public class BiDirectionLinkedList {
    
    private BiDirectionHeroNode biDirectionHeroNode;
    
    public boolean isEmpty(){
        return biDirectionHeroNode == null;
    }
    
    public int size(){
        int size = 0;
        if(this.isEmpty()){
            return size;
        }
        BiDirectionHeroNode tempNode = biDirectionHeroNode.getNext();
        while(true){            
            size++;
            if(tempNode.equals(biDirectionHeroNode)){
                break;
            }
            tempNode = tempNode.getNext();
        }      
        return size;
    }
    
    public void add(BiDirectionHeroNode node){
        if(this.isEmpty()){
            this.biDirectionHeroNode = node;
            this.biDirectionHeroNode.setNext(this.biDirectionHeroNode);
            this.biDirectionHeroNode.setPrevious(this.biDirectionHeroNode);
        }
        
        BiDirectionHeroNode tempNode = biDirectionHeroNode.getNext();
        while(true){
            if(tempNode == biDirectionHeroNode){
                break;
            }
            tempNode = tempNode.getNext();
        }        
        tempNode.setNext(node);
        biDirectionHeroNode.setPrevious(node);
        node.setNext(biDirectionHeroNode);
        node.setPrevious(tempNode);
    }
    
    public BiDirectionHeroNode get(int index){
        int size = this.size();       
        if(size-1>=index){
            int iterator = 0;
            BiDirectionHeroNode tempNode = this.biDirectionHeroNode;
            while(true){
               if(iterator == index){
                   break;
               }
               tempNode = tempNode.getNext();
               iterator++;
            }
            return tempNode;
        }else{
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }        
    }
    
}
