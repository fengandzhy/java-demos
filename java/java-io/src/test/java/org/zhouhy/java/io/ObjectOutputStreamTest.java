package org.zhouhy.java.io;

import org.junit.Test;
import org.zhouhy.java.io.entity.Employee;
import org.zhouhy.java.io.entity.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectOutputStreamTest {
    
    
    
    /**
     * 1. 当一个对象实现Serializable 的时候, 它就可以被写到ObjectOutputStream 里面, 
     * 如果这个ObjectOutputStream 是由FileOutputStream来构造的话, 那么这个对象就可以写到 file中. 
     * 可以用ObjectInputStream来恢复这个对象
     * */
    @Test
    public void testWriteObjectToFile(){
        Employee employee = new Employee("LiLei", 1000);
        OutputStreamWriter<Employee> outputStreamWriter = new OutputStreamWriter<>();
        outputStreamWriter.write(employee,"d://io//employee.dat");        
    }

    @Test
    public void testReadObjectFromFile(){  
        OutputStreamReader<Employee> reader = new OutputStreamReader<>();
        Employee employee = reader.read("d://io//employee.dat");
        System.out.println(employee.toString());        
    }
    
    /**
     * 1 如果父类实现了Serializable接口, 则子类也就自动实现这个接口了
     * */
    @Test
    public void testReadAndWrite(){
        Employee employee = new Employee("LiLei", 1000);
        Manager manager = new Manager("Jim", 20000);
        manager.setSecretary(employee);
        
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(manager);

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("d://io//employeeList.dat"));
            objectOutputStream.writeObject(employeeList);
            
            objectInputStream = new ObjectInputStream(new FileInputStream("d://io//employeeList.dat"));
            List<Employee> employees = (List<Employee>) objectInputStream.readObject();
            Iterator<Employee> iterator = employees.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            IOUtil.close(objectOutputStream);
        }
    }
    
    public void testReadAndWriteObjectWithTransient(){
        
    }
    
    
    
    
}
