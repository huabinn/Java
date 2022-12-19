package com.spring.dao.impl;

import com.spring.dao.UserDao;

/**
 * @author bin
 * @date 2022-12-14-17:12
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
