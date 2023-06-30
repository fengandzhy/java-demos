package org.frank.java.entity;

public class Classroom {
    private Integer Id;
    private String name;
    
    public Classroom(Integer Id, String name){
        this.Id = Id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Classroom{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
