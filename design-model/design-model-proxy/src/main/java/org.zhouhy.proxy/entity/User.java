package org.zhouhy.proxy.entity;

public class User {
    private Integer Id;
    private String username;

    public User() {
    }

    public User(Integer id, String username) {
        Id = id;
        this.username = username;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                '}';
    }    
}
