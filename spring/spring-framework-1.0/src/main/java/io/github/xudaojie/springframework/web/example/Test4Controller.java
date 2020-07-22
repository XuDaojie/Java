package io.github.xudaojie.springframework.web.example;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xdj
 */
public class Test4Controller extends MultiActionController {

    public ModelAndView test4 (HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/test4.jsp");
    }

    public ModelAndView test5 (HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURI() + "处理中");
        return new ModelAndView("/test4.jsp");
    }

// 抛异常.
//    public ModelAndView test5 (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        return new ModelAndView("/test4.jsp");
//    }
}
