package com.springmvc.controller;

import com.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-21-11:37
 */

/**
 * @RestController注解
 * @RestController注解是springMVC提供的一个复合注解，
 * 标识在控制器的类上，就相当于为类添加了 @Controller 注解，
 * 并且为其中的每个方法添加了 @ResponseBody 注解
 */
@Controller
public class TestAjaxController {

    // http://localhost:8080/springmvc/test/ajax?id=1

    @RequestMapping(value = "/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id: " + id);
        System.out.println("requestBody: " + requestBody);
        response.getWriter().write("bin");
    }

    /**
     * @RequestBody: 将 json 格式的请求参数转化为 Java 对象
     *  有相对应的类请使用相对应的类，没有请使用 Map
     *  为 类 | Map 自动装配需要使用 jackson依赖
     */
    @RequestMapping(value = "/test/ajax/json")
    /*public void testRequestBody(Integer id, @RequestBody Map<String, Object> user, HttpServletResponse response) throws IOException {
        System.out.println("id: " + id);
        System.out.println("requestBody: " + user);
        response.getWriter().write("bin");
    }*/
    public void testRequestBody(Integer id, @RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("id: " + id);
        System.out.println("requestBody: " + user);
        response.getWriter().write("bin");
    }

    /**
     * @ResponseBody: 将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
     *  响应浏览器 json 格式的数据
     *  需要使用 jackson依赖
     */
    @ResponseBody
    @RequestMapping("/test/ajax/response")
    public Map<Object, User> testResponseBody() {
        User user = new User();

        // List<User> list = new ArrayList<>();
        // list.add(user);

        Map<Object, User> userMap = new HashMap<>();
        userMap.put("bin", user);

        return userMap;
        // return "success";
    }
}
