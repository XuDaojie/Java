package io.github.xudaojie.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xdj on 2017/4/3.
 */
@Controller
public class HelloWorldController {

//    @RequestMapping("greeting")
//    public String helloWorld(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
//                             Model model) {
//        model.addAttribute("name", name);
//        System.out.println("springMVC/greeting");
//        return "greeting";
//    }

    @RequestMapping("springMVC/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "Spring MVC") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting"; // 视图的地址
    }
}
