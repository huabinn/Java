package com.spring.controller;

import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author bin
 * @date 2022-12-15-10:29
 */

// 设置 id 名字
@Controller("userController")
public class UserController {

    /**
     * 自动装配，会在 IOC 容器中自动寻找 UserService 类为 userService 赋值
     */
    @Autowired
    @Qualifier("zhangsan")
    private UserService userService;

    public UserController() {
    }

    //    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
//    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }
}
