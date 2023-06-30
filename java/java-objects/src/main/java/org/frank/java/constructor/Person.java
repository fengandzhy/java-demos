package org.frank.java.constructor;

public class Person {
    private int Id;
    private String name;
    
    public Person(String name){
        this.name = name;
        this.toString();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
