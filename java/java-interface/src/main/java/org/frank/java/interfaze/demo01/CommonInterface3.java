package org.frank.java.interfaze.demo01;

/**
 * 接口中也可以没有抽象方法了
 * */
public interface CommonInterface3 {
    default void defaultMethod() {
        System.out.println("CommonInterface1's default method　is running...");
    }
}
