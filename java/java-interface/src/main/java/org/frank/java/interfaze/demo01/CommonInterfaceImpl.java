package org.frank.java.interfaze.demo01;

public class CommonInterfaceImpl implements CommonInterface1, CommonInterface2{
    @Override
    public void doSomething() {
        
    }

    @Override
    public void defaultMethod() {
        System.out.println("CommonInterfaceImpl.defaultMethod()-------------start");
        CommonInterface1.super.defaultMethod();
        CommonInterface2.super.defaultMethod();
        System.out.println("CommonInterfaceImpl.defaultMethod()-------------end");       
    }

    @Override
    public void anotherDefaultMethod() {
        System.out.println("CommonInterfaceImpl.anotherDefaultMethod()-------------start");
        CommonInterface1.super.anotherDefaultMethod();
        CommonInterface2.super.anotherDefaultMethod();
        System.out.println("CommonInterfaceImpl.anotherDefaultMethod()-------------end");
    }
}
