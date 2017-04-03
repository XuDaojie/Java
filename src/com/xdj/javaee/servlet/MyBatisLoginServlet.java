package com.xdj.javaee.servlet;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.util.TextUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/4/3.
 */
public class MyBatisLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountBean accountBean = sqlSession.selectOne("findAccountByName", username);
//        AccountBean accountBean = sqlSession.selectOne("findAccountById", 1);
        if (accountBean == null) {
            resp.getWriter().println("账号不存在");
        } else if (TextUtils.equals(accountBean.getUsername(), username) &&
                TextUtils.equals(accountBean.getPassword(), password)) {
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
