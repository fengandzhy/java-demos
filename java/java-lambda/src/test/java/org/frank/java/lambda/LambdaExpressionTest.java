package org.frank.java.lambda;

import org.frank.java.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpressionTest {
    
    @Test
    public void LambdaExpressionWithoutParameter(){
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
    public void LambdaExpressionWithParameter(){
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
    public void LambdaExpressionWithParameters(){
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
}
