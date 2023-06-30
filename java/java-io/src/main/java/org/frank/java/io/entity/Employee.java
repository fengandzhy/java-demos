package org.frank.java.io.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;

    private double salary;

    public Employee(String name, double salary) {
        super();        
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double temp = salary * byPercent / 100;
        salary += temp;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[ Name = " + name + ", salary = " + salary +"]";
    }
}
