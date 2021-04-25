package org.zhouhy.proxy.handler;

import org.zhouhy.proxy.extralogic.Task;
import org.zhouhy.proxy.target.IStudent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentHandler implements InvocationHandler {
    
    private IStudent stu;
    
    private Task task;
    
    private String stuName;
    
    public StudentHandler(IStudent stu,Task task,String stuName){
        this.stu = stu;
        this.task = task;
        this.stuName = stuName;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        task.begin(stuName,method.getName());
        Object ret = method.invoke(stu,args);
        task.end(stuName,method.getName());
        return ret;
    }
}
