package org.zhouhy.java.demo01;

public class ClassATest {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        a.setName("A");
        
        ClassA.ClassB b = a.new ClassB();
        b.setName("B");
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        b.print();
    }
}
