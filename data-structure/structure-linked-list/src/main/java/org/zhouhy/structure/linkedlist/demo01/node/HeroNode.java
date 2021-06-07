package org.zhouhy.structure.linkedlist.demo01.node;

public class HeroNode {
    private Integer Id;
    private String name;
    private String nickname;
    private HeroNode next;

    public HeroNode() {
    }

    public HeroNode(Integer id, String name, String nickname) {
        Id = id;
        this.name = name;
        this.nickname = nickname;
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
