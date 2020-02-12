package com.day1.lwb.java8;

import com.day1.lwb.test.Employee;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Optional;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-02-12 18:08
 **/


/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {


    @Test
    public void  test3(){
        Optional<Employee> employee = Optional.ofNullable(new Employee());
        if (employee.isPresent()){
            System.out.println(employee.get());
        }

        Employee employee1 = employee.orElse(new Employee("张三"));
        System.out.println(employee1);
    }


    @Test
    public void test2(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }

    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
        System.out.println(employee);
    }
}
