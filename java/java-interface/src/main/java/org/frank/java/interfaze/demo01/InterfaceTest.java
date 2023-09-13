package org.frank.java.interfaze.demo01;

public class InterfaceTest {
    public static void main(String[] args) {
        CommonInterface1 commonInterface = new CommonInterfaceImpl();
        //抽象方法重写后调用
        commonInterface.doSomething();
        //默认方法重写后调用
        commonInterface.defaultMethod();
        commonInterface.anotherDefaultMethod();
    }
}
