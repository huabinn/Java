package com.spring.test;

import com.spring.controller.UserController;
import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author bin
 * @date 2022-12-15-10:34
 */
public class IOCByAnnotationTest {

    /**
     * 注解
     * @Component: 将类标识为普通组件
     * @Controller: 将类标识为控制层组件
     * @Service: 将类标识为业务层组件
     * @Repository: 将类标识为持久层层组件
     * 此时 bean 的 id 默认值为 类的小驼峰
     *
     * @Autowired 自动装配
     * 1. 标识在 成员变量上
     * 2. 标识在 有参构造方法上
     * 3. 标识在 成员变量的set方法上
     *
     * @Autowired 自动装配原理
     *  1. 默认使用 byType 的方式，在 IOC 容器中通过类型匹配某个 bean 为属性赋值
     *  2. 若 byType 无法匹配则自动转为 byName 的方式
     *  3. 若 byType 和 byName 都无法匹配 则在 @Autowired注解上使用 @Qualifier("")
     *      通过 value 值指定某个 bean 的id. 此时使用的是构造方法注入，注意构造方法的使用
     */

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController", UserController.class);

        System.out.println(userController);
        userController.saveUser();
        /*UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);*/
    }
}
