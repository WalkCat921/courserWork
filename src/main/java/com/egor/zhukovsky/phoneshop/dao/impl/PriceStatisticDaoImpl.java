package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.PriceStatisticDao;
import com.egor.zhukovsky.phoneshop.model.statistic.PriceStatistic;

import java.time.Month;
import java.util.List;

public class PriceStatisticDaoImpl  extends AbstractDao<PriceStatistic> implements PriceStatisticDao {


    private static volatile PriceStatisticDao instance;

    private PriceStatisticDaoImpl() {
    }

    public static PriceStatisticDao getInstance() {
        if (instance == null) {
            synchronized (PriceStatisticDao.class) {
                if (instance == null) {
                    instance = new PriceStatisticDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<PriceStatistic> findAllPriceStatistic() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM PriceStatistic ORDER BY month ASC").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public PriceStatistic getPriceStatistic(Long id) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.get(PriceStatistic.class,id);
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public PriceStatistic getPriceStatisticByMonth(Month month) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                List<PriceStatistic> list = sessionDB.createQuery("from PriceStatistic where month = :month").setParameter("month",month).list();
                if (list.isEmpty()){
                    return null;
                } else {
                    return list.get(0);
                }
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }
}
