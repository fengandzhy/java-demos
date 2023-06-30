package org.frank.java;

import lombok.extern.slf4j.Slf4j;
import org.frank.java.entity.*;
import org.junit.Test;
import org.zhouhy.java.entity.*;


import java.io.*;

@Slf4j
public class SerializableTest {
    
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Employee employee = new Employee("LiLei", 1000);
        Manager manager1 = new Manager("Jim", 20000);
        manager1.setSecretary(employee);

        Employee[] staff = new Employee[2];
        staff[0] = employee;
        staff[1] = manager1;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        objectOutputStream.writeObject(staff);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.dat"));
        Employee[] newStaff = (Employee[])objectInputStream.readObject();

        for(int i=0; i<newStaff.length; i++)
            System.out.println(newStaff[i]);

    }
    
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        User user = new User(1,"zhouhy","123456");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.dat"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.dat"));
        User user1 = (User)objectInputStream.readObject();
        log.info(user1.toString());
    }
    
    @Test
    public void test3() throws IOException, ClassNotFoundException {
        Classroom classroom = new Classroom(1,"A");
        Student student = new Student(1,"A","123",classroom);
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.dat"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.dat"));
        Student s = (Student)objectInputStream.readObject();
        log.info(s.toString());
    }
    
}
