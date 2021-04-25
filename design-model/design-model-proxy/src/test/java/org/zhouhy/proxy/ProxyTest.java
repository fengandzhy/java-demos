package org.zhouhy.proxy;

import org.junit.Test;
import org.zhouhy.proxy.entity.User;
import org.zhouhy.proxy.extralogic.Mornintor;
import org.zhouhy.proxy.extralogic.Task;
import org.zhouhy.proxy.handler.DaoHandler;
import org.zhouhy.proxy.handler.StudentHandler;
import org.zhouhy.proxy.interceptor.DaoInterceptor;
import org.zhouhy.proxy.interceptor.StudentInterceptor;
import org.zhouhy.proxy.target.IDao;
import org.zhouhy.proxy.target.IStudent;
import org.zhouhy.proxy.target.impl.DaoImpl;
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
    
    
    @Test
    public void DaoTest(){
        IDao<User> dao = new DaoImpl<User>();
        User user = new User(1,"Sam");
        Mornintor mornintor = new Mornintor();
        DaoHandler handler = new DaoHandler(dao,mornintor);
        IDao<User> daoProxy = (IDao<User>) handler.getProxyInstance();
        daoProxy.save(user);
        daoProxy.del(1);        
    }

    @Test
    public void DaoCglibTest(){
        IDao<User> dao = new DaoImpl<User>();
        User user = new User(1,"Sam");
        Mornintor mornintor = new Mornintor();
        DaoInterceptor interceptor = new DaoInterceptor(dao,mornintor);
        IDao<User> daoProxy = (IDao<User>) interceptor.getProxyInstance();
        daoProxy.save(user);
        daoProxy.del(1);
    }
}
