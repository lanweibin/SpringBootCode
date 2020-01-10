package com.lwb.springbootcrud.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-10 22:40
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter  doing");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
