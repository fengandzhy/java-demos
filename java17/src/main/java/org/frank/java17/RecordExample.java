package org.frank.java17;

/**
 * Record是Java中的一个不可变数据结构。它被设计为一种简洁的方式来模拟不可变的数据聚合。
 * 一旦一个Record实例被创建，它的状态（即字段的值）就不能被改变。
 * 
 * 每个Record本质上是一个final类，其所有字段也都是final的。
 * Record提供了一种快速定义数据载体的方法，自动生成所有字段的公开访问器（getter方法），但不提供setter方法。
 * 这意味着，如果你需要修改Record实例的任何数据，你需要创建一个新的Record实例。
 * */
public class RecordExample {
    public static void main(String[] args) {
        Person person = new Person("John", 35);
        System.out.println(person.name());
        System.out.println(person.age());
        System.out.println(person);
        
        
    }
}
