package com.spring.dao;

/**
 * @author bin
 * @date 2022-12-18-15:11
 */
public interface BookDao {

    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);

}
