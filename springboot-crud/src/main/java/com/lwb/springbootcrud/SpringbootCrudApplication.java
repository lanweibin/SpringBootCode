package com.lwb.springbootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }


    @Bean
    public ViewResolver myViewResolver(){
        return new  MyviewResolver();
    }

    private static  class MyviewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
