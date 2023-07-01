package org.frank.java.json.beans;



import java.util.Date;

public class Manager {
    
    private String name;  

    private Date date;

    public Manager() {
    }

    public Manager(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
