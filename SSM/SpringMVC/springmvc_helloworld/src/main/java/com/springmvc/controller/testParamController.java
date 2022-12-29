package com.springmvc.controller;

import com.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author bin
 * @date 2022-12-19-22:18
 */
@Controller
public class testParamController {


    // servlet 的获取参数的方法
    @RequestMapping("/param/servletAPI")
    public String getParamServletRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    /**
     * @RequestParam(value, required, defaultValue): 将 请求参数 和 控制器方法 的形参 绑定
     * value: 前端参数名
     * required: true | false
     *  true: 默认值，该参数必须要传
     *  false: 参数非必要，不传值为默认值
     * defaultValue: 参数默认值，此时和 required 的值无关
     *
     * @RequestHeader(value, required, defaultValue): 将 请求头信息 和 控制器方法 的形参 绑定
     *  用法与 @RequestParam 一样
     *
     * @CookieValue(value, required, defaultValue): 将 cookie数据 和 控制器方法 的形参 绑定
     *  用法与 @RequestParam 一样
     */
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "huabin") String username,
            @RequestParam(value = "passWord", required = false, defaultValue = "000") String password,
            @RequestHeader(value = "referer", defaultValue = "referer") String referer,
            @CookieValue(value = "JSESSIONID", defaultValue = "JSESSIONID") String myCookie
    ) {
        // 代码处用 username 而非 userName
        System.out.println("username: " + username + ", password: " + password);
        System.out.println("referer: " + referer + ", myCookie: " + myCookie);
        return "success";
    }

    /**
     * 将请求参数自动封装到对象中
     */
    @RequestMapping(value = "/param/bean", method = {RequestMethod.GET, RequestMethod.POST})
    public String getParamByBean(User user) {
        System.out.println(user);
        return "success";
    }
}
