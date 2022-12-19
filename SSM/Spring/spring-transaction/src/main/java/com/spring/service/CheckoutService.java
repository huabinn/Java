package com.spring.service;

/**
 * @author bin
 * @date 2022-12-18-16:36
 */
public interface CheckoutService {

    void checkout(Integer userId, Integer[] bookIds);

}
