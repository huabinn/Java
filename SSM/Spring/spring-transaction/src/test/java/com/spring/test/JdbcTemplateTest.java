package com.spring.test;

import com.spring.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-17-22:21
 */
// 指定当前测试类在 Spring 的测试环境中执行，此时就可以通过注入的方式直接获取 IOC 容器中的 bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置 Spring 测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, "root", "123", 24, "男", "123@qq.com");
    }

    @Test
    public void testGetUserById() {
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        String sql = "select * from t_user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }
}
