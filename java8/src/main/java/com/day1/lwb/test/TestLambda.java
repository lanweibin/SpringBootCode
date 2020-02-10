package com.day1.lwb.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-02-08 22:15
 **/
public class TestLambda {
    static List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void  test1(){
//        Collections.sort(emps, (e1, e2) -> {
//            if (e1.getAge() == e2.getAge()){
//                return e1.getName().compareTo(e2.getName());
//            }else {
//                return Integer.compare(e1.getAge(), e2.getAge());
//            }
//        });
//
//        for (Employee employee : emps){
//            System.out.println(employee.toString());
//        }

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }else {
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
            }
        });

        for (Employee employee : emps){
            System.out.println(employee.toString());
        }
    }


    @Test
    public void test2(){
        String str1 = strHandler("\t\t\t\t\t  哈喽", (x) -> x.trim());
        System.out.println(str1);
        System.out.println("\t\t\t\t\t  哈喽");
    }

    private String strHandler(String str, Myfunction mf) {
        return mf.getValue(str);
    }

}
