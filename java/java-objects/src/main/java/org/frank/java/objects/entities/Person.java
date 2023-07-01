package org.frank.java.objects.entities;

import java.util.HashMap;

public class Person {
    private int age;
    private String name;
    public Person(){
        
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int id) {
        age = id;
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
                "Age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Person other = (Person)obj;
        if(this.age != other.age)
            return false;
        if(!this.name.equals(other.name))
            return false;
        return true;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
