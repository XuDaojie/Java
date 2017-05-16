package com.xdj.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xdj on 2017/5/16.
 */
@Controller
public class RedisController {

    @RequestMapping("set")
    public String redisSet(@RequestParam("key") String key,
                           @RequestParam("value") String val) {
        return "greeting";
    }

    @RequestMapping(value = "springMVC/get")
    public String redisGet(@RequestParam("key") String key, Model model) {
        model.addAttribute("name", key);
        return "greeting"; // 视图的地址
    }
}
