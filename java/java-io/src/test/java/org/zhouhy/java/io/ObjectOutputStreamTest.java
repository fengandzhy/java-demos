package org.zhouhy.java.io;

import org.junit.Test;
import org.zhouhy.java.io.entity.*;

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
        ObjectOutputStreamWriter<Employee> objectOutputStreamWriter = new ObjectOutputStreamWriter<>();
        objectOutputStreamWriter.write(employee,"d://io//employee.dat");        
    }

    @Test
    public void testReadObjectFromFile(){  
        ObjectInputStreamReader<Employee> reader = new ObjectInputStreamReader<>();
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
    
    /**
     * 1 当一个字段被标记上transient 时它就无法实现序列化, 自然也就无法通过ObjectOutputStream来保存到文件中, 也无法恢复
     * 2 当一个字段被标记上transient 但同时还想写入文件中时, 就要在原本的类中加入 writeObject 和 readObject 这些方法必须是私有的
     *  在这些方法里手动加入write 和 read方法
     * */
    @Test
    public void testReadAndWriteObjectWithTransient(){
        User user = new User(1,"zhouhy","123456");
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream =  new ObjectOutputStream(new FileOutputStream("d://io//user.dat"));
            objectOutputStream.writeObject(user);
            
            objectInputStream = new ObjectInputStream(new FileInputStream("d://io//user.dat"));
            User u = (User)objectInputStream.readObject();
            System.out.println(u.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            IOUtil.close(objectOutputStream);
            IOUtil.close(objectInputStream);
        }
    }


    @Test
    public void testReadAndWriteObjectWithAnotherObject(){
        Classroom classroom = new Classroom(1,"A");
        Student student = new Student(1,"A","123",classroom);
        ObjectOutputStreamWriter<Student> writer = new ObjectOutputStreamWriter<>();
        writer.write(student,"d://io//student.dat");        
    }
    
}
