package io.github.xudaojie.springframework.web.example;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用代理的方式执行MultiActionController
 *
 * @author xdj
 */
public class Test6Delegate {

    public ModelAndView test6 (HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/test4.jsp");
    }
}
