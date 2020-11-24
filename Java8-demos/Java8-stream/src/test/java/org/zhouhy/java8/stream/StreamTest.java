package org.zhouhy.java8.stream;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.java8.entities.Customer;
import org.zhouhy.java8.entities.Order;
import org.zhouhy.java8.entities.Person;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    
    private List<Integer> list = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();
    private String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
    
    
    @Before
    public void beforeTest(){
        list = Arrays.asList(7,6,9,3,8,2,1);
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        personList.add(new Person("Lucy", 7900, 22, "female", "New York"));
        personList.add(new Person("Jim", 7900, 23, "female", "New York"));
        strList = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        
    }
    
    @Test
    public void filterTest(){
        list.stream().filter(x->x>6).forEach(System.out::println);
    }

    @Test
    public void findFirstTest(){
        Optional<Integer> findFirst = list.stream().filter(x->x>6).findFirst();
        System.out.println("匹配第一个值："+findFirst.get());
    }

    @Test
    public void findAnyTest(){
        Optional<Integer> findAny = list.parallelStream().filter(x->x>6).findFirst();
        System.out.println("匹配任意一个值："+findAny.get());
    }


    @Test
    public void anyMatchTest(){
        boolean anyMatch = list.stream().anyMatch(x->x>6);
        System.out.println("是否存在大于6的值："+anyMatch);
    }

    @Test
    public void findNameTest(){
        List<String> names = personList.stream()
                .filter(x->x.getSalary()>8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("工资大于8000的员工姓名："+names);
    }

    @Test
    public void maxTest(){
        Optional<String> str = strList.stream().max(Comparator.comparing(String::length));
        System.out.println("长度最大的字符串："+str.get());
        
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("最大的整数："+max.get());

        Optional<String> name = personList.stream().max(Comparator.comparing(Person::getSalary)).map(Person::getName);
        System.out.println("工资最大的员工姓名："+name.get());
    }

    @Test
    public void countTest(){
        long count = list.stream().filter(x->x>6).count();
        System.out.println("大于6的元素个数："+count);
    }

    @Test
    public void mapTest(){
        List<String> strings = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strings);
        
        List<Integer> integers = list.stream().map(x->x+3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + integers);

        List<Person> newPersonList = personList.stream().map(person -> {
            int salary = person.getSalary();
            person.setSalary(salary+1000);
            return person;
        }).collect(Collectors.toList());
        //newPersonList.stream().map(p->p.getSalary()).forEach(System.out::println);
        newPersonList.stream().forEach(person -> {
            System.out.println(person.getName()+"-->"+person.getSalary());
        });
    }


    
    /**
     * flatMap里面传的一定是一个stream
     * */
    @Test
    public void flatMapTest(){
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");

        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));
        garibaldi.addOrder(new Order(6))
                .addOrder(new Order(7));
        
        List<Customer> customers = Arrays.asList(sheridan,ivanova,garibaldi);
        
        customers.stream().map(Customer::getOrders).forEach(System.out::println);
        
        customers.stream()
                .flatMap(customer -> customer.getOrders().stream())//这一步里面一定是一个stream
                .forEach(System.out::println);
        
        List<String> list1 = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> list2 = list1.stream().flatMap(s -> { //这一步里面一定是一个stream
            String[] temp = s.split(",");
            Stream<String> s1 = Arrays.stream(temp);
            return s1;
        }).collect(Collectors.toList());
        
        System.out.println("处理前的集合：" + list1);
        System.out.println("处理后的集合：" + list2);
    }

    
    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     * 对Stream中的数据通过累加器accumulator迭代计算，最终得到一个Optional对象
     * */
    @Test
    public void reduceTest1(){
        Optional<Integer> accResult = Stream.of(1,2,3,4).reduce((acc,item)->{
            System.out.println("acc : " + acc);
            acc+=item;
            System.out.println("item: " + item);
            System.out.println("acc+ : " + acc);
            System.out.println("--------");
            return acc;
        });
        System.out.println(accResult);
    }


    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * 提供一个跟Stream中数据同类型的初始值identity，
     * 通过累加器accumulator迭代计算Stream中的数据，得到一个跟Stream中数据相同类型的最终结果
     * */
    @Test
    public void reduceTest2(){
        int accResult = Stream.of(1,2,3,4).reduce(0,(acc,item)->{            
            acc+=item;
            return acc;
        });
        System.out.println(accResult);
    }

    @Test
    public void reduceTest3(){
        Double[] doubles = {1.2,3.1,4.3,6.7};
        Optional<Double> maxDouble = Arrays.stream(doubles).reduce(Double::max);
        System.out.println("最大值是："+maxDouble.get());       
        
        Optional<Integer> maxSalary = personList.stream().map(Person::getSalary).reduce(Integer::max);
        System.out.print("最高工资是："+maxSalary.get());
    }

    
    /**
     * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
     *  其中BinaryOperator<T> extends BiFunction<T,T,T> 
     *  BiFunction 是输入两个数返回第三个数
     * */
    @Test
    public void reduceTest4(){
        Integer maxSalary = personList.stream().reduce(0, 
                (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);
        System.out.println("最高工资是："+maxSalary);
        
        List<Integer> temp = new ArrayList<>();
        Stream.of(1,2,3,4).reduce(temp,(acc,item)->{
            acc.add(item);
            return acc;
        },(acc,item)->null); //BinaryOperator 返回的是一个null
        System.out.println(temp);        
    }

    @Test
    public void toListTest(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> list1 = list.stream().filter(t->t%2==0).collect(Collectors.toList());
        System.out.println(list1);
    }

    @Test
    public void toSetTest(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        Set<Integer> set = list.stream().filter(t->t%2==0).collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void toMapTest(){
        Map<String,Integer> map = personList.stream()
                .filter(person -> person.getAge()>24)
                .collect(Collectors.toMap(Person::getName,person -> person.getSalary()));
        System.out.println("toMap:" + map);
    }

    @Test
    public void countingTest(){
        long count = personList.stream().collect(Collectors.counting());
        System.out.println("员工总数：" + count);
    }

    @Test
    public void averageTest(){
        double average = personList.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("平均年龄：" + average);
    }

    @Test
    public void maxByTest(){
        Optional<Integer> max = personList.stream().map(Person::getSalary)
                .collect(Collectors.maxBy(Integer::compareTo));
        Optional<Integer> min = personList.stream().map(Person::getSalary)
                .collect(Collectors.minBy(Integer::compareTo));
        System.out.println("最高工资：" + max.get());
        System.out.println("最低工资：" + min.get());
    }

    @Test
    public void sumTest(){
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        System.out.println("工资总和：" + sum);

        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工工资所有统计：" + collect);
    }

    @Test
    public void doubleSummaryStaticsTest(){
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工工资所有统计：" + collect);
        System.out.println("样本总数：" + collect.getCount());
        System.out.println("最高工资：" + collect.getMax());
        System.out.println("最低工资：" + collect.getMin());
        System.out.println("平均工资：" + collect.getAverage());
    }

    @Test
    public void partitioningByTest(){
        Map<Boolean,List<Person>> part = personList.stream()
                .collect(Collectors.partitioningBy(x->x.getSalary()>8000));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
    }

    @Test
    public void groupingByTest(){
        Map<String,List<Person>> group1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex));
        System.out.println("按性别分组情况：" + group1);

        Map<String, Map<String, List<Person>>> group2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按性别、地区：" + group2);
    }
    
    /**
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     * */
    @Test
    public void joiningTest(){
        List<String> list = Arrays.asList("A","B","C","D");
        String s1 = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + s1);
        
        String s2 = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + s2);
    }

    @Test
    public void parallelStreamTest(){
        List<Integer> list = new ArrayList<>();
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        for(int i=0;i<1000000;i++){
            list.add(i);
        }
        list.parallelStream().forEach((a1)->{
            Thread thread = Thread.currentThread();
            threadSet.add(thread);
        });
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");
    }

    @Test
    public void sortTest1(){
        List<String> names1 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .map(Person::getName).collect(Collectors.toList());
        
        List<String> names2 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        List<String> names3= personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getAge))
                .map(Person::getName).collect(Collectors.toList());
        
        List<String> name4 = personList.stream()
                .sorted((a1,a2)->{
                    if(a1.getSalary() == a2.getSalary()){
                        return a2.getAge()-a1.getAge();
                    }
                    return a1.getSalary()-a2.getSalary();
                }).map(Person::getName).collect(Collectors.toList());
        
        System.out.println("按工资自然排序：" + names1);
        System.out.println("按工资降序排序：" + names2);
        System.out.println("先按工资再按年龄自然排序：" + names3);
        System.out.println("先按工资升序再按年龄降序排序：" + name4);
    }    
}
