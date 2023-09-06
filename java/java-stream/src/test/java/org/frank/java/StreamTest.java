package org.frank.java;

import org.frank.java.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.frank.java.domain.Order;
import org.frank.java.domain.Person;


import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private List<Integer> list = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();
    private String[] strArr = {"abcd", "bcdd", "defde", "fTr"};


    @Before
    public void beforeTest() {
        list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
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
    public void filterTest() {
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        List<String> nameList = personList.stream()
                .filter(p -> p.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println("工资大于8000的员工:"+nameList);
    }

    /**
     * 注意这里 .orElseGet 里面是一个supplier, 就是说里面得是一个函数(确切的说是一个函数式接口的对象), 它返回的是这个函数的返回值
     * */
    @Test
    public void findFirstTest() {
        Optional<Integer> findFirst = list.stream().filter(x -> x > 9).findFirst();
        System.out.println("匹配第一个值：" + findFirst.orElseGet(() -> null));        
    }

    /**
     * 注意这里 .orElse 里面是需要返回的值, 在 parallelStream 上用 findAny 返回的是一个非固定的值
     * 在 stream 上用 findAny 返回的永远都是一个固定值
     * */
    @Test
    public void findAnyTest() {
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        System.out.println("匹配任意一个值：" + findAny.orElse(null));

        Optional<Integer> findAny1 = list.stream().filter(x -> x > 6).findAny();
        System.out.println("匹配任意一个值：" + findAny1.orElse(null));
    }


    @Test
    public void anyMatchTest() {
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("是否存在大于6的值：" + anyMatch);
    }    

    @Test
    public void maxTest() {
        Optional<String> str = strList.stream().max(Comparator.comparing(String::length));
        System.out.println("长度最大的字符串：" + str.get());

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("最大的整数：" + max.get());

        Optional<String> name = personList.stream().max(Comparator.comparing(Person::getSalary)).map(Person::getName);
        System.out.println("工资最大的员工姓名：" + name.get());
    }

    @Test
    public void countTest() {
        long count = list.stream().filter(x -> x > 6).count();
        long employeeCount = personList.stream().filter(x -> x.getSalary() > 8000).count();
        System.out.println("大于6的元素个数：" + count);
        System.out.println("工资大于8000个数：" + employeeCount);
    }

    /**
     * map 里面传入一个Function接口的实例, 该实例执行自己继承自函数式接口的方法后可以返回任意值
     * */
    @Test
    public void mapTest() {
        List<String> strings = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strings);

        List<Integer> integers = list.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + integers);

        List<Person> newPersonList = personList.stream().map(person -> {
            int salary = person.getSalary();
            person.setSalary(salary + 1000);
            return person;
        }).collect(Collectors.toList());        
        newPersonList.stream().forEach(person -> {
            System.out.println(person.getName() + "-->" + person.getSalary());
        });
        
        System.out.println("***********************************************************");
        
        personList.stream().forEach(person -> {
            System.out.println(person.getName() + "-->" + person.getSalary());
        });
        
        personList.stream().map(Person::getName).forEach(System.out::println);
    }


    /**
     * flatMap 里面也传入一个Function接口的实例, 该实例执行自己继承自函数式接口的方法后必须返回stream
     */
    @Test
    public void flatMapTest1() {
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

        List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);

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
     * 
     * BinaryOperator 是什么意思, 就是你需要有两个输入值, 一个输出值, 这个输入值和输出值是同一个类型的就行.
     */
    @Test
    public void reduceTestWithOneParameter() {
        Optional<Integer> accResult = Stream.of(1, 2, 3, 4).reduce((acc, item) -> {
            System.out.println("acc : " + acc);
            acc += item;
            System.out.println("item: " + item);
            System.out.println("acc+ : " + acc);
            System.out.println("--------");
            return acc;
        });
        System.out.println(accResult);

        Double[] doubles = {1.2, 3.1, 4.3, 6.7};
        Optional<Double> maxDouble = Arrays.stream(doubles).reduce(Double::max);
        System.out.println("最大值是：" + maxDouble.get());

        Optional<Double> sumDouble = Arrays.stream(doubles).reduce(Double::sum);
        System.out.println("所有元素的和为：" + sumDouble.get());

        Optional<Integer> maxSalary = personList.stream().map(Person::getSalary).reduce(Integer::max);
        System.out.print("最高工资是：" + maxSalary.get());
    }


    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * 提供一个跟Stream中数据同类型的初始值identity，
     * 通过累加器accumulator迭代计算Stream中的数据，得到一个跟Stream中数据相同类型的最终结果
     * 
     * identity 是个初始值, accumulator 还是一样, 它是一个函数式接口的具体实现, 它需要两个输入参数, 一个返回值，输入参数和返回值需要同一类型, 并且和identity的类型相同
     * 
     */
    @Test
    public void reduceTestWithTwoParameters() {
        int accResult = Stream.of(1, 2, 3, 4).reduce(0, (acc, item) -> {
            acc += item;
            return acc;
        });
        System.out.println(accResult);

        int accResult1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::max);
        System.out.println(accResult1);
    }
    
    /**
     * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
     * 其中BinaryOperator<T> extends BiFunction<T,T,T>
     * BiFunction 是输入两个数返回第三个数
     * 
     * identity 这是个初始值, 
     * accumulator 这是个二元操作, 跟之前一样, 用于将流中的元素逐个操作成一个中间结果 
     * combiner 用于将多个中间结果合并成一个最终结果。这个形式的reduce方法允许在并行流中执行归约操作。
     */
    @Test
    public void reduceTestWithThreeParameters() {
        Integer maxSalary1 = personList.stream().reduce(0,
                (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);
        System.out.println("最高工资是：" + maxSalary1); // 一般不是parallelStream combiner 起不到作用

        Integer maxSalary2 = personList.parallelStream().reduce(0,
                (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) ->  max1 > max2 ? max1 : max2);
        System.out.println("最高工资是：" + maxSalary2);

        List<Integer> temp = new ArrayList<>();
        Stream.of(1, 2, 3, 4).reduce(temp, (acc, item) -> {
            acc.add(item);
            return acc;
        }, (acc, item) -> null); //BinaryOperator 返回的是一个null
        System.out.println(temp);

        List<Integer> numList = Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE);
        long result = numList.stream().reduce(0L,(a,b) ->  a + b, (a,b)-> 0L);
        System.out.println(result);
    }

    @Test
    public void toListTest() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> list1 = list.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
        System.out.println(list1);
    }

    @Test
    public void toSetTest() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        Set<Integer> set = list.stream().filter(t -> t % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void toMapTest() {
        Map<String, Integer> map = personList.stream()
                .filter(person -> person.getAge() > 24)
                .collect(Collectors.toMap(Person::getName, person -> person.getSalary()));
        System.out.println("toMap:" + map);
    }

    @Test
    public void countingTest() {
        long count1 = personList.stream().collect(Collectors.counting());
        System.out.println("员工总数：" + count1);
        
        long count2 = personList.stream().count();
        System.out.println("员工总数：" + count2);
    }

    @Test
    public void averageTest() {
        double average = personList.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("平均年龄：" + average);       
    }

    @Test
    public void maxByTest() {
        Optional<Integer> max = personList.stream().map(Person::getSalary)
                .collect(Collectors.maxBy(Integer::compareTo));
        Optional<Integer> min = personList.stream().map(Person::getSalary)
                .collect(Collectors.minBy(Integer::compareTo));
        System.out.println("最高工资：" + max.get());
        System.out.println("最低工资：" + min.get());
    }

    @Test
    public void sumTest() {
        Integer sum1 = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        System.out.println("工资总和：" + sum1);

        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("工资总和：" + sum2.get());

        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工工资所有统计：" + collect);
    }

    @Test
    public void doubleSummaryStaticsTest() {
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工工资所有统计：" + collect);
        System.out.println("样本总数：" + collect.getCount());
        System.out.println("最高工资：" + collect.getMax());
        System.out.println("最低工资：" + collect.getMin());
        System.out.println("平均工资：" + collect.getAverage());
    }

    /**
     * 将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * 这个map 的 key 值只能是Boolean 
     * */
    @Test
    public void partitioningByTest() {
        Map<Boolean, List<Person>> part = personList.stream()
                .collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
    }

    @Test
    public void groupingByTest() {
        Map<String, List<Person>> group1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex));
        System.out.println("按性别分组情况：" + group1);

        Map<String, Map<String, List<Person>>> group2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按性别、地区：" + group2);
    }

    /**
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     */
    @Test
    public void joiningTest() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String s1 = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + s1);

        String s2 = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + s2);
    }

    @Test
    public void parallelStreamTest() {
        List<Integer> list = new ArrayList<>();
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        list.parallelStream().forEach((a1) -> {
            Thread thread = Thread.currentThread();
            threadSet.add(thread);
        });
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有" + Runtime.getRuntime().availableProcessors() + "个cpu");
    }

    @Test
    public void sortTest1() {
        List<String> names1 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .map(Person::getName).collect(Collectors.toList());

        List<String> names2 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        
        List<String> names3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getAge))
                .map(Person::getName).collect(Collectors.toList());
        
        
        List<String> name4 = personList.stream()
                .sorted((a1, a2) -> {
                    if (a1.getSalary() == a2.getSalary()) {
                        return a2.getAge() - a1.getAge();
                    }
                    return a1.getSalary() - a2.getSalary();
                }).map(Person::getName).collect(Collectors.toList());

        System.out.println("按工资自然排序：" + names1);
        System.out.println("按工资降序排序：" + names2);
        System.out.println("先按工资倒序再按年龄自然排序：" + names3);
        System.out.println("先按工资升序再按年龄降序排序：" + name4);
    }
}
