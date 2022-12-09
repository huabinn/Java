package com.mybatis.mapper;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-06-20:13
 */
public interface UserMapper {

    User getUserByUsername(String username);

    User checkLoginByMap(Map<String, Object> map);

    int insertUser(User user);

    /*
        @Param注解
            Mybatis会自动把参数放进map集合里面
            在映射文件调用的时候直接使用 value 值即可
    */
    User checkLoginByParam(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 查询一条或多条数据
     */

    /**
     * 查询单条数据放在 Map 里面
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询多条结果放在 Map 列表里面
     * @return
     */
    List<Map<String, Object>> getAllUserToMap();

    /**
     * 模糊查询
     */
    List<Map<String, Object>> getUserByLike(@Param("like") String like);

}
