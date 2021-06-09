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
    
    
}
