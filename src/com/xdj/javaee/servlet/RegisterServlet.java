package com.xdj.javaee.servlet;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.db.AccountDAO;

import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/4/2.
 */
public class RegisterServlet extends HttpServlet {

    private AccountDAO mAccountDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        mAccountDAO = (AccountDAO) WebApplicationContextUtils
                .getWebApplicationContext(getServletContext())
                .getBean("accountDAO");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountBean account = mAccountDAO.getAccount(username);
        if (account == null) {
            account = new AccountBean();
            account.setUsername(username);
            account.setPassword(password);
            if (mAccountDAO.addAccount(account)) {
                response.getWriter().println("注册成功");
            } else {
                response.getWriter().println("注册失败");
            }
        } else {
            response.getWriter().println("账号已存在");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
