package org.zhouhy.proxy.interceptor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.zhouhy.proxy.extralogic.Task;
import org.zhouhy.proxy.target.IStudent;
import org.zhouhy.proxy.target.impl.Student;

import java.lang.reflect.Method;

public class StudentInterceptor implements MethodInterceptor {
    
    private Task task;
    
    private Object target;
    
    private String stuName;
    
    public StudentInterceptor(Object target,Task task,String stuName){
        this.target = target;
        this.task = task;
        this.stuName = stuName;
    }
    
    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        
        
        task.begin(stuName,method.getName());
        //Object ret = methodProxy.invokeSuper(target,objects);
        Object ret = method.invoke(target,objects);
        task.end(stuName,method.getName());
        return ret;
    }
}
