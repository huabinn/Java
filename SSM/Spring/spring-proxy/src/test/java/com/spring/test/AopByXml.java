package com.spring.test;

import com.spring.proxy.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bin
 * @date 2022-12-17-17:21
 */
public class AopByXml {
    @Test
    public void testAop() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        Integer a = bean.div(1, 1);
        System.out.println("------------a=" + a);
    }
}
