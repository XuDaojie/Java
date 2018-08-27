package com.ald.news.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xdj
 */
@Controller
public class ApiDocsController {

    /**
     * 请求重定向至swagger文档接口
     */
    @GetMapping("/users/v2/api-docs")
    public String apiDocs() {
//        return "redirect:/v2/api-docs";
        return "forward:/v2/api-docs?group=a-api";
    }

}
