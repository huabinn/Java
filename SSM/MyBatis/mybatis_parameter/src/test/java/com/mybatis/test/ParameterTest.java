package com.mybatis.test;

import com.mybatis.bean.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-06-20:21
 */
public class ParameterTest {

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User allUser = mapper.getUserByUsername("bin");
        sqlSession.close();
        System.out.println("--------------");
        System.out.println(allUser);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "bin");
        map.put("password", "123456");

        User allUser = mapper.checkLoginByMap(map);
        sqlSession.close();
        System.out.println("--------------");
        System.out.println(allUser);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null, "滨", "123456", 18, "1", "123@qq.com");

        int result = mapper.insertUser(user);
        sqlSession.close();
        System.out.println("--------------");
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User allUser = mapper.checkLoginByParam("bin", "123456");

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(allUser);
    }

    /**
     * 单条查询
     */
    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map map = mapper.getUserByIdToMap(1);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(map);
    }

    /**
     * 多条查询
     */
    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Map<String, Object>> list = mapper.getAllUserToMap();

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Map<String, Object>> list = mapper.getUserByLike("b");

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }
}
