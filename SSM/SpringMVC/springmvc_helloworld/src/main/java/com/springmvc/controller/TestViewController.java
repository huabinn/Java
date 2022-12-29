package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bin
 * @date 2022-12-20-17:18
 */
@Controller
public class TestViewController {

    // ThymeleafView
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView() {
        return "success";
    }

    // 转发视图
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView() {
        return "forward:/test/model";
    }

    // 重定向视图
    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }

}
