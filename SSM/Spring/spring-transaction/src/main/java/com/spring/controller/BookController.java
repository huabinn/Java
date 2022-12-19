package com.spring.controller;

import com.spring.service.BookService;
import com.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author bin
 * @date 2022-12-18-15:21
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    // 买单本书
    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }

    // 买多本书
    public void checkout(Integer userId, Integer[] bookIds){
        checkoutService.checkout(userId, bookIds);
    }

}
