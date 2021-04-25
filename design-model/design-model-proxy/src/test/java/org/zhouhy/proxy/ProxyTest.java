package org.zhouhy.proxy;

import org.junit.Test;
import org.zhouhy.proxy.extralogic.Task;
import org.zhouhy.proxy.handler.StudentHandler;
import org.zhouhy.proxy.interceptor.StudentInterceptor;
import org.zhouhy.proxy.target.IStudent;
import org.zhouhy.proxy.target.impl.Student;

import java.lang.reflect.Proxy;

public class ProxyTest {
    
    @Test
    public void StudentTest(){
        Student stu = new Student();
        stu.setStudentName("Sam");
        Task task = new Task();
        StudentHandler handler = new StudentHandler(stu,task,stu.getStudentName());
        IStudent stuProxy = (IStudent) Proxy.newProxyInstance(stu.getClass().getClassLoader(),stu.getClass().getInterfaces(),handler);
        stuProxy.doAssignment();
        stuProxy.haveLesions();
    }

    @Test
    public void StudentCglibTest(){
        Student stu = new Student();
        stu.setStudentName("Sam");
        Task task = new Task();
        StudentInterceptor interceptor = new StudentInterceptor(stu,task,stu.getStudentName());
        Student stuProxy = (Student) interceptor.getProxyInstance();
        stuProxy.doAssignment();
        stuProxy.haveLesions();        
    }

    
}
