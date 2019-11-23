package com.example.config;

import com.example.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-11-23 14:18
 **/
@Configuration
public class Myconfig {

    @Bean
    public HelloService helloService11(){
        System.out.println("执行helloSerive方法");
        return  new HelloService();
    }
}
