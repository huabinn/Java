package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bin
 * @date 2022-12-21-21:48
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello() {
        System.out.println(1/0);
        System.out.println("hello");
        return "success";
    }
}
