package com.mybatis.utils;

import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bin
 * @date 2022-12-06-16:51
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession() {

        SqlSession sqlSession = null;
        try {
            // 获取核心配置文件输入流
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取 SqlSessionFactoryBuilder 对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            // 获取 SqlSessionFactory 对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

            // 获取sql的会话对象SqlSession，是Mybatis提供的才做数据库对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
            // 设置自动提交事务
            sqlSession = sqlSessionFactory.openSession(true);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }
}
