package org.zhouhy.java.lambda;

import org.junit.Test;
import org.zhouhy.java.lambda.entity.Address;
import org.zhouhy.java.lambda.interfaces.ConsumerInterfaceA;
import org.zhouhy.java.lambda.interfaces.ConsumerInterfaceB;
import org.zhouhy.java.lambda.interfaces.Creator;

import java.util.function.Consumer;

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

        Runnable r2 = () -> {
            System.out.println("世界那么大，我不想去看了");
        };

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
}
