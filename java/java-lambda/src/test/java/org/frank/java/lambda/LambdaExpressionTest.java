package org.frank.java.lambda;

import org.frank.java.lambda.entity.Employee;
import org.frank.java.lambda.interfaces.ConsumerInterfaceA;
import org.frank.java.lambda.interfaces.PredicateInterface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaExpressionTest {
    
    /**
     * lambda 表达式的本质就是函数式接口的实现, 如果一个接口中只声明了一个抽象方法, 那么该接口就是函数式接口.
     * */
    @Test
    public void lambdaExpressionWithoutParameter(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门.");
            }
        };
        r1.run();
        System.out.println("************************************************************");
        r1 = () -> System.out.println("我爱北京天安门.");        
        Thread t1 = new Thread(r1);
        t1.start();        
    }

    @Test
    public void lambdaExpressionWithParameter(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("我爱北京天安门!");
        System.out.println("************************************************************");
        consumer = o -> System.out.println(o);
        consumer.accept("我爱北京天安门!");
    }
    
    @Test
    public void lambdaExpressionWithParameters(){
        Comparator<Employee> comparator = (o1, o2) -> (int) (o1.getSalary() - o2.getSalary());

        Employee emp1 = new Employee(1001,"Tom1",23,5800);
        Employee emp2 = new Employee(1002,"Tom2",23,5600);
        Employee emp3 = new Employee(1003,"Tom3",23,5900);
        
        Employee[] employees = new Employee[]{emp1,emp2,emp3};        
        Arrays.sort(employees,comparator);
        Arrays.asList(employees).forEach(System.out::println);
        
        System.out.println("************************************************************");
        
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        
        employeeList.sort(comparator);
        
        employeeList.stream().forEach(System.out::println);
    }
    
    @Test
    public void consumerLambdaExpression(){
        ConsumerInterfaceA<String> consumerA = a -> System.out.println(a);
        consumerA.accept("我是个消费型接口.");        
    }

    @Test
    public void predicateLambdaExpression(){
        PredicateInterface<String> predicate = s -> s.indexOf("a")== -1;
        List<String> strings = new ArrayList<>();
        String[] strArray = new String[] {"ab", "bc", "cd", "da", "bd","ef"};
        for(int i = 0; i<strArray.length;i++){
            if(predicate.test(strArray[i])){
                strings.add(strArray[i]);
            }
        }
        System.out.println(strings);
    }
    
    /**
     * 意思是 supplier 接口里的 get方法的方法体, 由这个 emp1 的 getName 方法来实现
     * 那具体的来说就是, 接口抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值类型相同. 如果不同, 它就会编译报错
     * 
     * Supplier<String> supplier1 = emp1::getSalary;
     * */
    @Test
    public void methodReference(){
        Employee emp1 = new Employee(1001,"Tom1",23,5800);
        Supplier<String> supplier = emp1::getName;
        System.out.println(supplier.get());        
    }

    /**
     * 方法引用 类::实例方法
     * Comparator 这个接口的抽象方法有两个参数,一个返回值 int compare(T o1, T o2);
     * String 这个类的实例方法只有一个参数, 一个返回值 int compareTo(String anotherString), str1.compareTo(str2);
     * 所以当 String::compareTo 这样调用的时候 str1就相当于是上面的o1, str2就相当于上面的o2 
     * */
    @Test
    public void methodReferenceStatic(){
        Comparator<String> comparator = String::compareTo;
        String[] strArray = new String[]{"Tom","Jim","Tim"};       
        List<String> list = Arrays.stream(strArray).sorted(comparator).collect(Collectors.toList());
        System.out.println(list);
    }
}
