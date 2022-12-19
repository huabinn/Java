package com.spring.test;

import com.spring.proxy.Calculator;
import com.spring.proxy.CalculatorImpl;
import com.spring.proxy.CalculatorStaticProxy;
import com.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author bin
 * @date 2022-12-16-17:15
 */
public class ProxyTest {

    @Test
    public void test() {
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        calculatorStaticProxy.add(1, 2);
    }

    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(1,1);
        //proxy.div(1,1);
    }
}
