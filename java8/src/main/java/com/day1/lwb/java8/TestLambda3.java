package com.day1.lwb.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: SpringBootCode
 * @description:
 * 四大核心接口
 * @author: LWB
 * @create: 2020-02-09 16:54
 **/
public class TestLambda3 {

    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello", "nihao", "saa", "fsadfasd", "aa");

        List<String> filter = filter(list, (x) -> x.length() > 3);
        for (int i = 0; i < filter.size(); i++) {
            System.out.println(filter.get(i));
        }
    }

    public List<String> filter(List<String> list, Predicate<String> pre){

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
             if (pre.test(list.get(i))){
                 list1.add(list.get(i));
             }
        }
        return  list1;
    }

    @Test
    public void test3(){
        String s = strHandler("\t\t\t\t\t  hahahahahha", (x) -> x.trim());
        System.out.println(s);

        String abcv = strHandler("abcv", (x) -> x.toUpperCase());
        System.out.println(abcv);
    }

    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }


    @Test
    public void test2(){
        List<Integer> res = getList(10, () -> (int)(Math.random() * 100));
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));

        }
    }

    public List<Integer> getList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
             Integer n = sup.get();
             list.add(n);

        }

        return list;
    }


    @Test
    public void test1(){
        happy(10000,  (x) -> System.out.println("这是" + x + "啊啊啊啊阿"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
