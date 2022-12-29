package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bin
 * @date 2022-12-19-11:36
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String portal() {

        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {

        return "success";
    }

}
