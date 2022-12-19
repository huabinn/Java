package com.spring.test;

import com.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author bin
 * @date 2022-12-18-15:54
 */

/**
 * 声明式事务配置步骤
 * 1. 在 Spring 配置文件中配置事务管理器
 * 2. 在需要被事务管理的方法上添加 @Transactional 注解，该方法即可被事务管理
 *
 * 1. 标识在方法上
 * 2. 标识在类上，则类中所有的方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1, 1);
    }

    @Test
    public void testBuySomeBook(){
        bookController.checkout(1, new Integer[]{1, 2});
    }

}
