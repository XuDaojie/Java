package com.ald.news.user.controller.api;

import com.ald.news.user.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xdj
 * @date 2018/7/21
 */
@Controller
public class MockController {

    @Value("${spring.profiles.active}")
    private String profiles;

    @ResponseBody
    @GetMapping("/user/success")
    public Response success() {
        return Response.ok().message(profiles).build();
    }

    @ResponseBody
    @GetMapping("/user/bad")
    public Response bad() {
        return Response.bad().message(profiles).build();
    }

    @ResponseBody
    @GetMapping("/user/exception")
    public Response exception() {
        throw new NullPointerException(profiles + "-exception");
    }
}
