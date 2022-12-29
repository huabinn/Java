package com.springmvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author bin
 * @date 2022-12-22-11:21
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    // 设置一个配置类代替 Spring 的配置文件
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    // 设置一个配置类代替 SpringMVC 的配置文件
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    // 设置 SpringMVC 的前端控制器 DispatcherServlet 的 url-pattern
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    // 设置当前的过滤器
    protected Filter[] getServletFilters() {
        // 创建编码过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
    }
}
