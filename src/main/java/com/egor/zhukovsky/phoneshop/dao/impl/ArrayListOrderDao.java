package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.dao.OrderDao;
import com.egor.zhukovsky.phoneshop.model.order.Order;

import java.util.NoSuchElementException;

public class ArrayListOrderDao extends AbstractDao<Order> implements OrderDao {
    private static volatile OrderDao instance;

    private ArrayListOrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            synchronized (OrderDao.class) {
                if (instance == null) {
                    instance = new ArrayListOrderDao();
                }
            }
        }
        return instance;
    }

    @Override
    public Order getBySecureId(String secureId) throws NoSuchElementException, NullPointerException {
        synchronized (LOCK) {
            return super.findAll().stream()
                    .filter(order -> secureId.equals(order.getSecureId()))
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);
        }
    }
}