package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.entity.Employee;
import org.zhouhy.java.entity.Manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerizableTest {
    
    @Test
    public void test1() throws IOException {
        Employee employee = new Employee("LiLei", 1000);
        Manager manager1 = new Manager("Jim", 20000);
        manager1.setSecretary(employee);

        Employee[] staff = new Employee[2];
        staff[0] = employee;
        staff[1] = manager1;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        objectOutputStream.writeObject(staff);
        objectOutputStream.close();
    }
}
