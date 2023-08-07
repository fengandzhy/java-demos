package org.frank.collections.comparable.demo01;

import org.junit.Test;

import java.util.*;

public class ComparableTest {
    
    /**
     * 对于实现了 Comparable 接口的类来说, 加入到list 之后，可以用 Collections.sort(employeeList); 排序
     * */
    @Test
    @SuppressWarnings("DuplicatedCode")    
    public void printList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Tom", 0));
        employeeList.add(new Employee(2, "Mickey", 10));
        employeeList.add(new Employee(3, "Jerry", 10));
        employeeList.add(new Employee(7, "John", 2));
        employeeList.add(new Employee(5, "Sarah", 10));
        
        System.out.println("排序前：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        Collections.sort(employeeList);
        System.out.println("排序后：");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);
    }

    @Test
    @SuppressWarnings("DuplicatedCode")
    public void printSet() {
        Set<Employee> employeeSet = new TreeSet<>();
        employeeSet.add(new Employee(10, "Tom", 0));
        employeeSet.add(new Employee(2, "Mickey", 10));
        employeeSet.add(new Employee(3, "Jerry", 10));
        employeeSet.add(new Employee(7, "John", 2));
        employeeSet.add(new Employee(5, "Sarah", 10));

        employeeSet.stream().map(Employee::getName).forEach(System.out::println);
    }
}
