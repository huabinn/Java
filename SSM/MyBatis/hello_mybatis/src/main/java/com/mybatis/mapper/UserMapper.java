package com.mybatis.mapper;

import com.mybatis.bean.User;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-06-14:44
 */
public interface UserMapper {

    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUser();
}
