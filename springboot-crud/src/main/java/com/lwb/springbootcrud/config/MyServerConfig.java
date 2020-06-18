package com.lwb.springbootcrud.config;

import com.lwb.springbootcrud.filter.MyFilter;
import com.lwb.springbootcrud.listener.MyListener;
import com.lwb.springbootcrud.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-10 22:05
 **/
@Configuration
public class MyServerConfig {

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8080);
            }
        };
    }

    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/myServlet");

        return bean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));

        return filter;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> listener = new ServletListenerRegistrationBean<>(new MyListener());

        return listener;

    }
}
