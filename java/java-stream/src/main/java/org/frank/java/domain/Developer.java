package org.frank.java.domain;

public class Developer {
	private String name;
	private double salary;
	private int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Developer() {
		super();
	}
	public Developer(String name,double salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}	
}	
