package com.day1.lwb.java8;

import com.day1.lwb.test.Employee;
import com.day1.lwb.test.Employee.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-02-10 17:34
 **/
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );


    @Test
    public void test3(){
        Map<Object, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(collect);
    }

    @Test
    public void test2(){
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer reduce = list.stream().reduce(0,(x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("----------------------------------------");

        Optional<Double> reduce1 = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(reduce1.get());
    }
}
