package org.zhouhy.structure.linkedlist.demo04.node;


public class Boy {
    private Integer Id;
    private Boy next;

    public Boy() {
    }

    public Boy(Integer id) {
        Id = id;       
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
