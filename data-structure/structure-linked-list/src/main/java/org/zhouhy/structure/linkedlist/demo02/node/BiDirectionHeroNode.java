package org.zhouhy.structure.linkedlist.demo02.node;

public class BiDirectionHeroNode {
    private Integer Id;
    private String name;
    private String nickname;
    private BiDirectionHeroNode next;
    private BiDirectionHeroNode previous;
    
    public BiDirectionHeroNode(Integer id, String name, String nickname){
        this.Id =  id;
        this.name = name;
        this.nickname = nickname;
    }

    public BiDirectionHeroNode() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public BiDirectionHeroNode getNext() {
        return next;
    }

    public void setNext(BiDirectionHeroNode next) {
        this.next = next;
    }

    public BiDirectionHeroNode getPrevious() {
        return previous;
    }

    public void setPrevious(BiDirectionHeroNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "BiDirectionHeroNode{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
