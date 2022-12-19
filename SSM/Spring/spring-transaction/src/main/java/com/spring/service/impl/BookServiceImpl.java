package com.spring.service.impl;

import com.spring.dao.BookDao;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bin
 * @date 2022-12-18-15:12
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * @Transactional
     *  isolation: 事务的隔离级别
     *  propagation: REQUIRED | REQUIRES_NEW 设置事务的传播行为
     *      REQUIRED: 默认值 利用 参照调用方法的事务
     *      REQUIRES_NEW: 以自身方法为一个事务
     */
    @Override
    @Transactional(
            readOnly = false,
            timeout = 3,
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRES_NEW
    )
    public void buyBook(Integer bookId, Integer userId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);

    }
}
