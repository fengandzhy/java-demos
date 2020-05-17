package org.zhouhy.stream.entity;

public class User {
	private Integer id;
	private double height;
	
	public User(Integer id,double height) {
        this.id = id;        
        this.height = height;
    }

	public Integer getId() {
		return id;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +                
                ", height=" + height +
                '}';
    }
}
