package com.xdj.javaee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/3/28.
 */
public class StartUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("StartUpServlet doGet");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("StartUpServlet init");
    }
}
