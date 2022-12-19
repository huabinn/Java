package com.spring.test;

import com.spring.bean.Student;
import com.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bin
 * @date 2022-12-14-14:48
 */
public class ScopeTest {

    /**
     * bean 的作用域
     *  默认是单例模式
     */
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        // 获取 IOC 容器中的 bean
        Student student1 = ioc.getBean(Student.class);

        Student student2 = ioc.getBean(Student.class);

        System.out.println(student1.equals(student2));
    }


    /**
     * bean 的生命周期
     *  实例化
     *  依赖注入
     *  初始化
     *  销毁
     *
     * 单例模式在 获取 IOC 容器的时候执行生命周期函数 前三个步骤
     * 多例子模式在 获取 IOC 容器中的 bean 的时候执行 前三个步骤
     */
    @Test
    public void lifecycle() {

        // 获取 IOC 容器
        // ConfigurableApplicationContext 是 ApplicationContext 的子接口，提供了 刷新 及 销毁 方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("lifecycle.xml");


        // 获取 IOC 容器中的 bean
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }

    @Test
    public void factoryBean() {

        // 获取 IOC 容器
        // ConfigurableApplicationContext 是 ApplicationContext 的子接口，提供了 刷新 及 销毁 方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");

        // 获取 IOC 容器中的 bean
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }

}
