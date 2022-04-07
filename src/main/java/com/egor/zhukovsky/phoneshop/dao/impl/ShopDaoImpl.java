package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.ShopDao;
import com.egor.zhukovsky.phoneshop.model.shop.Shop;
import org.hibernate.Session;

import java.util.List;

public class ShopDaoImpl extends AbstractDao<Shop> implements ShopDao {
    private static volatile ShopDao instance;

    private ShopDaoImpl() {
    }

    public static ShopDao getInstance() {
        if (instance == null) {
            synchronized (ShopDao.class) {
                if (instance == null) {
                    instance = new ShopDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Shop> findAllShop() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try {
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM Shop").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }
}
