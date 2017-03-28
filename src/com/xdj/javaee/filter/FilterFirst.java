package com.xdj.javaee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xdj on 2017/3/28.
 */
public class FilterFirst implements Filter {
    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("start doFilter");
        chain.doFilter(req, resp);
        System.out.println("end doFilter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
