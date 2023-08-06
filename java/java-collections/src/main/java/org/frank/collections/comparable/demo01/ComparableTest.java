package org.frank.collections.comparable.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparableTest {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Tom", 0));
        employeeList.add(new Employee(2, "Mickey", 10));
        employeeList.add(new Employee(3, "Jerry", 10));
        employeeList.add(new Employee(7, "John", 2));
        employeeList.add(new Employee(5, "Sarah", 10));

        employeeList.stream().map(Employee::getName).forEach(name -> System.out.println(name));
        
        System.out.println("===============================================================");

        Set<Employee> employeeSet = new TreeSet<>();
        employeeSet.add(new Employee(10, "Tom", 0));
        employeeSet.add(new Employee(2, "Mickey", 10));
        employeeSet.add(new Employee(3, "Jerry", 10));
        employeeSet.add(new Employee(7, "John", 2));
        employeeSet.add(new Employee(5, "Sarah", 10));

        employeeSet.stream().map(Employee::getName).forEach(name -> System.out.println(name));
    }
}
