package org.frank.java;

/**
 * 1. 成员内部类, 指的就是类里面的类, 例如ClassA 里面的 ClassB
 * 
 * 2. 创建成员内部类的实例首先要有外部类的实例 ClassA.ClassB b = a.new ClassB();
 * 
 * 3. 成员内部类中访问外部的同名变量是这样访问的ClassA.this.name
 * 
 * 4. 局部内部类, 指定义在方法或者代码块里的类, 这种类不能有public和private的修饰, 这种类不能在外部使用
 * 因为它的定义范围就是定义它的方法或者代码块里面. 例如奔雷的ClassC 里面的ClassD. 外部是没有办法创建
 * ClassD的, 只能在fun1里面创建
 * 
 * 
 * */
public class InnerClassApp {
    public static void main(String[] args) {
        
    }
}
