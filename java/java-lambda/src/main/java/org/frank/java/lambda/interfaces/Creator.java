package org.frank.java.lambda.interfaces;

/**
 * 函数式接口就是指只有一个抽象方法的接口, 跟是否加 @FunctionalInterface 注解没有关系. 
 * 就跟继承关系中, 子类方法是否加@Override都可以对父类方法覆盖一样.
 * 
 * 加了 @FunctionalInterface 的意思就是 如果再加一个抽象方法就会报错
 * */
@FunctionalInterface
public interface  Creator<A,B,C,D> {
    D create(A a, B b, C c);
}
