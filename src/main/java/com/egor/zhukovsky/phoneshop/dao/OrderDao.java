package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.order.Order;

import java.util.List;
import java.util.NoSuchElementException;

public interface OrderDao extends DAO<Order> {
    Order getBySecureId(String secureId) throws NoSuchElementException, NullPointerException;

    List<Order> findAllOrder();
}
