package com.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author bin
 * @date 2022-12-17-17:22
 */
@Component
public class LoggerAspectXml {


    //    @Before("execution(public int com.spring.proxy.CalculatorImpl.add(int, int))")
//    @Before("execution(* com.spring.proxy.CalculatorImpl.*(..))")

    public void beforeAdviceMethod(JoinPoint joinPoint) {

        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("beforeAdviceMethod 前置通知, 方法： " + signature.getName() + ",参数： " + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("After 后置通知, 方法： " + signature.getName() + ",参数： " + Arrays.toString(args));
    }

    /**
     * 返回值通知
     * returning: 接收表示方法的返回值
     */
    public void afterReturnAdviceMethod(JoinPoint joinPoint, Object result) {
        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        System.out.println("AfterReturning 返回值通知, 方法： " + signature.getName() + ",返回值： " + result);
    }

    /**
     * throwing： 接收目标对象方法的异常参数
     */
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("AfterThrowing 异常通知, 方法： " + signature.getName() + ", 异常： " + ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {

        // 环绕通知的返回值一定要和目标对象的返回值一致

        Object result = null;
        try {
            System.out.println(" 环绕通知--前置通知");
            // 表示 目标对象方法 执行
            result = joinPoint.proceed();

            System.out.println(" 环绕通知--返回通知");
        } catch (Throwable throwable) {
            System.out.println(" 环绕通知--异常通知");
        } finally {
            System.out.println(" 环绕通知--后置通知");
        }
        return result;
    }
}
