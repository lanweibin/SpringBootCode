package com.example;

import com.example.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.applet.AppletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Person person;

    @Autowired
    public ApplicationContext ioc;

    @Test
    void beanTest(){
        System.out.println(ioc.containsBean("helloService11"));
    }

    @Test
    void contextLoads() {
        System.out.println("你好");
    }

}
