package com.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bin
 * @date 2022-12-21-22:01
 */

/**
 * 拦截器的三个方法：
 *
 * preHandle：控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，返回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法
 * postHandle：控制器方法执行之后执行postHandle()
 * afterCompletion：处理完视图和模型数据，渲染视图完毕之后执行afterCompletion()
 *
 * 多个拦截器的执行顺序
 *  若每个拦截器的preHandle()都返回true
 *  此时多个拦截器的执行顺序和拦截器在SpringMVC的配置文件的配置顺序有关：
 *
 * 若某个拦截器的preHandle()返回了false
 *  preHandle()返回false和它之前的拦截器的preHandle()都会执行，
 *  postHandle()都不执行，
 *  返回false的拦截器之前的拦截器的afterCompletion()会执行
 */
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
