package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.OrderDao;
import com.egor.zhukovsky.phoneshop.model.order.Order;

import java.util.Arrays;
import java.util.List;
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
            return findAllOrder().stream()
                    .filter(order -> secureId.equals(order.getSecureId()))
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);
        }
    }

    @Override
    public List<Order> findAllOrder() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM Order ").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }
}