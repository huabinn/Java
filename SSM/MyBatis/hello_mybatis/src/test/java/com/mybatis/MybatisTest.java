package com.mybatis;

import com.mybatis.bean.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bin
 * @date 2022-12-06-14:56
 */
public class MybatisTest {

    @Test
    public void testInsert() throws IOException {
        // 获取核心配置文件输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取sql的会话对象SqlSession，是Mybatis提供的才做数据库对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

//        int result = sqlSession.insert("com.mybatis.mapper.UserMapper.insertUser");

        // 获取 UserMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用 mapper 接口中的方法。实现添加用户的功能
        int result = mapper.insertUser();

        System.out.println("结果" + result);

        // 提交事务
//        sqlSession.commit();
        // 关闭 sqlSession 对象
        sqlSession.close();
    }

    /**
     * 修改功能，删除功能类似
     */
    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }
    @Test
    public void deleteUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void getAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        sqlSession.close();
        System.out.println("--------------");
        allUser.forEach(System.out::println);
    }
}
