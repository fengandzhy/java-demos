package org.zhouhy.proxy.handler;

import org.zhouhy.proxy.extralogic.Mornintor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaoHandler implements InvocationHandler {
    private Object target;
    private Mornintor mornintor;
    
    public DaoHandler(Object target,Mornintor mornintor){
        this.target = target;
        this.mornintor = mornintor;
    }
    
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        mornintor.begin();
        Object obj = method.invoke(target,args);
        mornintor.end();
        return obj;
    }
}
