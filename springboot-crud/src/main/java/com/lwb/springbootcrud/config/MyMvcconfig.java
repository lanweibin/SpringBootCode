package com.lwb.springbootcrud.config;

import com.lwb.springbootcrud.component.LoginHandlerInterceptor;
import com.lwb.springbootcrud.component.MyLocaleResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-11-28 21:27
 **/

@Configuration
public class MyMvcconfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/myConfig").setViewName("success");
    }


    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/", "/user/login","/webjars/**");
//            }
        };
        return webMvcConfigurerAdapter;
    }

//    @Bean
//    public LocaleResolver localResolver(){
//        return new  MyLocaleResolver();
//    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }



}
