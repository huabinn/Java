package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author bin
 * @date 2022-12-19-16:28
 */
@Controller
/**
 * 该类下的所有路径前缀都要加上 /test,如 /test/index
 */
@RequestMapping("/test")
public class ProtalController {

    /**
     * @RequestMapping
     *  value
     *  method
     *  params
     *      "value": 当前请求中一定要携带该参数
     *      "!value": 当前请求中不能携带该参数
     *      "value=value"： 当前请求中一定要携带参数 value
     *      "value!=value"： 当前请求中不能携带参数 value
     * headers: 请求头，用法与 params 一样
     *      请求头错误 报404
     *
     * @RequestMapping(): value值支持设置一些特殊字符
     *  ?: 表示任意单个字符
     *  *: 表示任意个数任意字符
     *  **: 任意层数的任意目录，只能使用在双斜线中，前后不能有任意的其他字符，如 / ** /"test/
     * 路径中的占位符 {}, 配合 @PathVariable 使用
     *
     * @GetMapping @PostMapping @DeleteMapping @PutMapping
     */

    @RequestMapping("/index")
    public String portall() {

        return "index";
    }

    /**
     * /test/hello | /test/aaa都能匹配到
     *
     * test/hello?aaa=1&ccc=1
     */
    @RequestMapping(
            value = {"/hello", "aaa"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"aaa", "!bbb", "ccc=1", "ddd!=0"},
            headers = {"Content-Type"}
    )
    public String portalls() {

        return "success";
    }

    @RequestMapping("/a?a")
    public String separator() {
        return "success";
    }

    // 路径中的占位符
    @RequestMapping("/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("username: " + username + ",id: " + id);
        return "success";
    }
}
