package org.frank.java.interfaze.demo01;

import java.util.Hashtable;

public class CommonInterfaceImpl implements CommonInterface1, CommonInterface2{
    @Override
    public void doSomething() {
        System.out.println("I am doing something.");
    }

    @Override
    public void defaultMethod() {
        System.out.println("CommonInterfaceImpl.defaultMethod()-------------start");
        CommonInterface1.super.defaultMethod();
        CommonInterface2.super.defaultMethod();
        System.out.println("CommonInterfaceImpl.defaultMethod()-------------end");  
        
        System.out.println(DEFAULT_NAME); // 接口的成员变量(事实上是常量) 必须背实现      
    }

    @Override
    public void anotherDefaultMethod() {
        System.out.println("CommonInterfaceImpl.anotherDefaultMethod()-------------start");
        CommonInterface1.super.anotherDefaultMethod();
        CommonInterface2.super.anotherDefaultMethod();
        System.out.println("CommonInterfaceImpl.anotherDefaultMethod()-------------end");
        CommonInterface1.staticMethod();        
    }
}
