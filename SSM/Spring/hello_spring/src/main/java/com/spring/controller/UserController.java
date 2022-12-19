package com.spring.controller;

import com.spring.service.UserService;
import com.spring.service.impl.UserServiceImpl;

/**
 * @author bin
 * @date 2022-12-14-17:11
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }
}
