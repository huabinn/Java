package com.spring.test;

import com.spring.bean.Clazz;
import com.spring.bean.HelloWorld;
import com.spring.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bin
 * @date 2022-12-12-14:31
 */
public class HelloWorldTest {

    @Test
    public void test() {

        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取 IOC 容器中的 bean
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();

    }


    /**
     * 获取 bean
     * 1. 根据 id 获取， 需要强转类型
     * 2. 根据类型获取， 要求 IOC 容器中有且只有一个该类型的 bean (常用)
     * 3. 根据 id 和 类型 获取。
     *
     * 根据类型获取 bean 时，在满足 bean 唯一的前提下，其实只看： [对象 instanceof 指定类型] 的
     * 返回结果，只要返回 true 就可以和指定类型匹配，(即获取该类的实现接口也能获取到 bean)
     */
    @Test
    public void testIOC() {

        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 获取 IOC 容器中的 bean
        Student student = ioc.getBean(Student.class);
        System.out.println(student);

    }

    @Test
    public void testIOCList() {

        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 获取 IOC 容器中的 bean
        Clazz clazz = ioc.getBean(Clazz.class);
        clazz.getStudent().forEach(System.out::println);

    }
}
