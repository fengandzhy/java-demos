package org.frank.java.interfaze.demo01;

public interface CommonInterface2 {

    //抽象方法
    public void doSomething();

    //默认方法
    default void defaultMethod() {
        System.out.println("CommonInterface2's default method is running...");
    }

    //默认方法可以有多个
    default void anotherDefaultMethod() {
        System.out.println("CommonInterface2's second default method is running...");
    }

    //静态方法
    static void staticMethod() {
        System.out.println("CommonInterface2's static method is running...");
    }

    //静态方法也可以有多个
    static void anotherStaticMethod() {
        System.out.println("CommonInterface2's second static method is running...");
    }

}
