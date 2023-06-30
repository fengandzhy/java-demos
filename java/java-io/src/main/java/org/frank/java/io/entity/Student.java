package org.frank.java.io.entity;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 1 如果Classroom没有实现Serializable 接口, 那么将Student实例放到流中就会出错
 * 
 * */
public class Student implements Serializable {
    private Integer Id;
    private String name;
    private String password;
    transient private Classroom classroom;
    
    public Student(Integer Id,String name,String password,Classroom classroom){
        super();
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.classroom = classroom;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", classroom=" + classroom +
                '}';
    }

    /**
     * 1. 虽然writeObject 可以帮被标记为transient 的属性写入流, 但是这个属性本身也必须是实现Serializable接口的
     * 例如字啊本例中 transient private Classroom classroom; 由于Classroom没有实现Serializable 接口, 所以这里
     * 无法将其写入流中，那么同理也无法从流中恢复它. 但之前例子的 transient private String password; 就可以,
     * 因为String是实现了Serializable接口的类 
     * */
    private void writeObject(ObjectOutputStream oos)throws IOException {
        oos.defaultWriteObject();        
        oos.writeObject(classroom);
    }

    private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException{
        ois.defaultReadObject();        
        classroom = (Classroom)ois.readObject();
    }
}
