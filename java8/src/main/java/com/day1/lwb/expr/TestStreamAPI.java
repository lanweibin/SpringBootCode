package com.day1.lwb.expr;

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
 * @create: 2020-02-10 18:09
 **/
public class TestStreamAPI {

    @Test
    public void test1(){
        Integer[] arr = new Integer[]{1, 2, 3, 4};

        Arrays.stream(arr)
              .map((x) -> x * x)
              .forEach(System.out::println);
    }

    /*
	 2.	怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
	 */
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    @Test
    public void  test2(){
        Optional<Integer> reduce = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(reduce.get());
    }
}
