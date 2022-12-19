package com.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author bin
 * @date 2022-12-14-15:18
 */
public class User {

    private Integer id;

    private String name;

    public User() {
        System.out.println("实例化");
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("依赖注入");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void initMethod() {
        System.out.println("初始化");
    }

    public void destroyMethod() {
        System.out.println("销毁");
    }
}
