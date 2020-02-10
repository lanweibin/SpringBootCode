package com.day1.lwb.java8;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-02-09 18:32
 **/
public class TestLambda4 {


    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        list.stream()
            .map((x) -> x.toUpperCase())
            .forEach(System.out::println);
    }


    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();


        Integer[] arr = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(arr);

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);


    }
}
