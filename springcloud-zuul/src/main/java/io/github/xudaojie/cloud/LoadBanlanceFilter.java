package io.github.xudaojie.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.apache.commons.lang3.StringUtils;
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

        Object serviceIdObj = ctx.get("serviceId");
        String serviceId = null;
        if (serviceIdObj != null) {
            serviceId = serviceIdObj.toString();
        }

        if (StringUtils.equals("news-user", serviceId)) {
            String zone = request.getHeader("x-zone");
            if (!StringUtils.isBlank(zone)
//                    && StringUtils.equals(zone, "zone1")
            ) {
                RibbonFilterContextHolder.getCurrentContext()
                        .add("zone", zone);
            } else {
                RibbonFilterContextHolder.getCurrentContext()
                        .add("zone", "zone");
            }
        }
        return null;
    }
}
