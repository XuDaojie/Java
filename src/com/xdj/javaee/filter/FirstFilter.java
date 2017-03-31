package com.xdj.javaee.filter;

import com.xdj.javaee.db.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xdj on 2017/3/28.
 */
public class FirstFilter implements Filter {
    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("start doFilter");
        chain.doFilter(req, resp);
        System.out.println("end doFilter");

        try {
            DBUtils.m1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
