package org.zhouhy.java.entity;

public class Manager extends Employee{

    private Employee secretary;
    
    public Manager(String name, double salary) {
        super(name, salary);
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return super.toString() + "[ secretary = " + secretary +"]";
    }
}
