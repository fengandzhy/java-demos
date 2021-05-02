package org.zhouhy.java.entity;

public class Dummy {
    
    private String nickName;
    private String username;
    private String description;
    private Integer Id;
    private boolean flag;
    
    public Dummy(){
        
    }

    public Dummy(String nickName, String username, String description, Integer id, boolean flag) {
        this.nickName = nickName;
        this.username = username;
        this.description = description;
        Id = id;
        this.flag = flag;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
