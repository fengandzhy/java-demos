package org.zhouhy.java.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
    
    private Integer id;
    private String name;
    transient private String password;

    public User(Integer id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //这样设置时
    private void writeObject(ObjectOutputStream oos)throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(password);
    }

    private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        password = (String)ois.readObject();
    }
}
