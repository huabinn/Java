package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.service.UserService;

/**
 * @author bin
 * @date 2022-12-14-17:11
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
