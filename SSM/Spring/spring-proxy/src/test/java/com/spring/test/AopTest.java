package com.spring.test;

import com.spring.proxy.Calculator;
import com.spring.proxy.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bin
 * @date 2022-12-17-15:25
 */
public class AopTest {

    @Test
    public void testAop() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        Integer a = bean.div(1, 1);
        System.out.println("------------a=" + a);
    }
}
