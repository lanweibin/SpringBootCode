package com.day1.lwb.java8;

import com.day1.lwb.test.Employee;
import com.day1.lwb.test.Employee.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-02-10 14:37
 **/
public class TestStreamAPI {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE)

    );

    @Test
    public void  test3(){
        Optional<Double> max = emps.stream().map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(max.get());
    }

    @Test
    public void  test2(){
        long count = emps.stream().count();
        System.out.println(count);
    }

    @Test
    public void test1(){
        boolean b = emps.stream().allMatch((x) -> x.getStatus().equals(Status.BUSY));
        System.out.println(b);

        boolean b1 = emps.stream().anyMatch((x) -> x.getStatus().equals(Status.FREE));
        System.out.println(b1);

        boolean b2 = emps.stream().noneMatch((x) -> x.getStatus().equals(Status.BUSY));
        System.out.println(b2);
    }

}
