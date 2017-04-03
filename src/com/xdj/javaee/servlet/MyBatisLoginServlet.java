package com.xdj.javaee.servlet;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.dao.AccountDAO;
import com.xdj.javaee.util.TextUtils;

import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/4/3.
 */
public class MyBatisLoginServlet extends HttpServlet {

    private AccountDAO mAccountDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        mAccountDAO = (AccountDAO) WebApplicationContextUtils
                .getWebApplicationContext(getServletContext())
                .getBean("myBatisAccountDAO");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AccountBean accountBean = mAccountDAO.getAccount(username);
        if (accountBean != null &&
                TextUtils.equals(username, accountBean.getUsername()) &&
                TextUtils.equals(password, accountBean.getPassword())) {
            resp.getWriter().println("登录成功");
        } else {
            resp.getWriter().println("用户名或密码错误");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
