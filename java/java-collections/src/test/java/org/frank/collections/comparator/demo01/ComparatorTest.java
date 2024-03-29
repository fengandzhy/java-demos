package org.frank.collections.comparator.demo01;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    @Test    
    public void printList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Tom", 0));
        employeeList.add(new Employee(2, "Mickey", 10));
        employeeList.add(new Employee(3, "Jerry", 10));
        employeeList.add(new Employee(7, "John", 2));
        employeeList.add(new Employee(5, "Sarah", 10));

        System.out.println("排序前：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        employeeList.sort(Comparator.comparing(Employee::getName));
        System.out.println("排序后：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        employeeList.sort(Comparator.comparing(Employee::getName).reversed());
        System.out.println("反向排序后：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        Collections.sort(employeeList, Comparator.comparing(Employee::getName));
        System.out.println("用Collections排序后：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("用Stream反向排序后：");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(Employee::getName).forEach(System.out::println);
    }
}
