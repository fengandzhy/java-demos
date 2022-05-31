package org.zhouhy.java.lambda;

import org.junit.Test;
import org.zhouhy.java.lambda.entity.Address;
import org.zhouhy.java.lambda.entity.Employee;
import org.zhouhy.java.lambda.entity.ParticularInstanceRef;
import org.zhouhy.java.lambda.entity.StaticMethodRef;
import org.zhouhy.java.lambda.interfaces.ConsumerInterfaceA;
import org.zhouhy.java.lambda.interfaces.ConsumerInterfaceB;
import org.zhouhy.java.lambda.interfaces.Creator;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {    
    
    @Test
    @SuppressWarnings({"Convert2Lambda", "CodeBlock2Expr"})
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("世界那么大，我想去看看");
            }
        };

        r1.run();

        System.out.println("***********************");

        Runnable r2 = () -> System.out.println("世界那么大，我不想去看了");
        
        r2.run();
    }

    @Test
    @SuppressWarnings({"Convert2Lambda", "CodeBlock2Expr", "Anonymous2MethodRef", "Convert2MethodRef"})
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("*******************");

        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听得人当真了，一个是说的人当真了");
    }

    @Test
    @SuppressWarnings({"CodeBlock2Expr", "Convert2MethodRef"})
    public void test3(){
        ConsumerInterfaceA<String> consumerA = (a) -> {
            System.out.println(a);
        };

        ConsumerInterfaceB<String> consumerB = (b) -> {
            System.out.println(b);
        };        
        consumerB.accept("AABB");
        consumerA.accept("BBCC");
    }

    @Test
    public void test4(){
        Creator<String, String, String, Address> creator = (a,b,c) ->{
            System.out.println("对象正在创建...");
            return new Address(a,b,c);
        };
        
        Address address = creator.create("LiaoNing", "ShenYang", "YaTa");
        System.out.println(address);
    }

    @Test
    public void test5(){
        Employee emp = new Employee(1001,"Tom",23,5600);

        @SuppressWarnings("Convert2MethodRef") Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("*******************");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test6(){
        @SuppressWarnings("Convert2MethodRef") BiPredicate<String,String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abcd"));
        System.out.println(pre1.test("abc","abc"));

        System.out.println("*******************");
        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("abc","abd"));
    }

    @Test
    public void test7(){
        Employee employee = new Employee(1001, "Jerry", 23, 6000);
        
        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("*******************");

        Function<Employee,String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));

        Function<String,Integer> func3 = employee::getFromString;
        System.out.println(func3.apply("10086"));
    }

    @Test
    public void test8(){
        ParticularInstanceRef ref = new ParticularInstanceRef();
        Function<String, Integer> function = ref::refMethod;        
        System.out.println(function.apply("10086"));
    }

    @Test
    public void test9(){
        Function<String, Integer> function = StaticMethodRef::staticMethod;        
        System.out.println(function.apply("10086"));
    }

    @Test
    public void test10(){
        Function<Integer,Employee> func2 = Employee :: new;
        Employee employee = func2.apply(1002);
        System.out.println(employee);
    }
}
