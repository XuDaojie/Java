package io.github.xudaojie.springframework.web.example;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求执行时长
 *
 * @author xdj
 */
public class DurationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startDate", System.currentTimeMillis());
        System.out.println(DurationInterceptor.class.getName() + " preHandle:处理请求处理前");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(DurationInterceptor.class.getName() + " preHandle:正在处理请求");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(DurationInterceptor.class.getName() + " preHandle:处理请求完成后");
        long startDate = (long) request.getAttribute("startDate");
        System.out.print("执行时长：" + (System.currentTimeMillis() - startDate) + "ms");
    }
}
