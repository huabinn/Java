package com.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author bin
 * @date 2022-12-22-11:05
 */
@ControllerAdvice
public class ExceptionController {

    // 使用注解配置异常处理
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
