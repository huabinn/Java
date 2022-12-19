package com.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author bin
 * @date 2022-12-17-15:13
 */
@Component
@Aspect        // 将当前组件标识为切面
@Order(1)      // 切面优先级，值越小，优先级越高
public class LoggerAspect {

    /**
     * 在切面中需要通过指定注解将方法标识为通知方法
     * @Before 前置通知，在目标方法执行之前执行
     * @After 后置通知，在方法的 finally 字句中执行
     * @AfterReturning 返回值通知，在目标方法返回值之后执行
     * @AfterThrowing 异常通知，在方法的 catch 字句中执行
     *
     * execution()
     *  第一个 * 标识任意的方法和修饰符
     *  第二个 * 标识类中的方法
     *  ..表示任意的参数列表
     *  类的地方也可以使用 *
     */

    @Pointcut("execution(* com.spring.proxy.CalculatorImpl.*(..))")
    public void pointCut() {}

//    @Before("execution(public int com.spring.proxy.CalculatorImpl.add(int, int))")
//    @Before("execution(* com.spring.proxy.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {

        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("beforeAdviceMethod 前置通知, 方法： " + signature.getName() + ",参数： " + Arrays.toString(args));
    }

    @After("pointCut()")
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
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturnAdviceMethod(JoinPoint joinPoint, Object result) {
        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        System.out.println("AfterReturning 返回值通知, 方法： " + signature.getName() + ",返回值： " + result);
    }

    /**
     * throwing： 接收目标对象方法的异常参数
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        // 获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("AfterThrowing 异常通知, 方法： " + signature.getName() + ", 异常： " + ex);
    }

    @Around("pointCut()")
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
