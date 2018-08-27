package com.ald.cloud.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;

/**
 * @author xdj
 * @date 2018/8/27
 */
@Component
public class LoadBanlanceFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String zone = request.getHeader("x-zone");

        RibbonFilterContextHolder.getCurrentContext()
                .add("zone", zone);

        return null;
    }
}
