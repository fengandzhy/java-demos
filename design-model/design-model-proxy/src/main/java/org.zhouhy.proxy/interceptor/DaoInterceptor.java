package org.zhouhy.proxy.interceptor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.zhouhy.proxy.extralogic.Mornintor;

import java.lang.reflect.Method;

public class DaoInterceptor implements MethodInterceptor {
    
    private Object targeet;
    private Mornintor mornintor;
    
    public DaoInterceptor(Object targeet,Mornintor mornintor){
        this.targeet = targeet;
        this.mornintor = mornintor;        
    }
    
    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targeet.getClass());
        enhancer.setCallback(this);
        
        return enhancer.create();
    }
    
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        mornintor.begin();
        Object ret = method.invoke(targeet,objects);        
        mornintor.end();
        return ret;
    }
}
