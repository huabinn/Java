package com.spring.dao.impl;

import com.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author bin
 * @date 2022-12-15-10:31
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
