package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author bin
 * @date 2022-12-14-16:37
 */
public class UserFactoryBean implements FactoryBean<User> {

    /**
     * FactoryBean 是一个接口
     * getObject: 通过一个对象交给 IOC 容器
     * getObjectType: 设置所提供对象的类型
     * isSingleton: 是否为单例
     *
     * 当把 FactoryBean 的实现类交给 Bean 时，会将 getObject() 返回的对象交出去
     */

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
