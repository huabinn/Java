package com.spring.test;

import com.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bin
 * @date 2022-12-14-17:28
 */
public class AutowireTest {

    /**
     * 自动装配
     * 根据指定的策略，在 IOC 容器中匹配某个 bean ，自动为bean中的 类类型的属性 或 接口类型的属性 赋值
     */
    @Test
    public void testAutowire() {

        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");

        UserController bean = ioc.getBean(UserController.class);

        bean.saveUser();
    }
}
