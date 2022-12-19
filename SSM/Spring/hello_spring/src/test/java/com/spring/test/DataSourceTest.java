package com.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author bin
 * @date 2022-12-12-17:36
 */
public class DataSourceTest {

    /**
     * 测试 Druid 数据库连接池
     * @throws SQLException
     */
    @Test
    public void test() throws SQLException {

        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-dataSource.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
