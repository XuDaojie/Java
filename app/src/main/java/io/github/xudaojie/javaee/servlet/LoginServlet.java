package io.github.xudaojie.javaee.servlet;

import io.github.xudaojie.javaee.bean.AccountBean;
import io.github.xudaojie.javaee.dao.AccountDAO;
import io.github.xudaojie.javaee.util.TextUtils;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/4/2.
 */
public class LoginServlet extends HttpServlet {
    private AccountDAO mAccountDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        mAccountDAO = (AccountDAO) context.getBean("accountDAO");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountBean accountBean = mAccountDAO.getAccount(username);
        if (accountBean != null &&
                TextUtils.equals(username, accountBean.getUsername()) &&
                TextUtils.equals(password, accountBean.getPassword())) {
            response.getWriter().println("登录成功");
        } else {
            response.getWriter().println("用户名或密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
