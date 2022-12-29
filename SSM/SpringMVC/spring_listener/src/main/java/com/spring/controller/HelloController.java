package com.spring.controller;

import com.spring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author bin
 * @date 2022-12-29-15:54
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
}
