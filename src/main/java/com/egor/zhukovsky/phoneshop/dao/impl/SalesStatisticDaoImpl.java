package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.SalesStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.VisitorsStatisticDao;
import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.Month;
import java.util.List;

public class SalesStatisticDaoImpl  extends AbstractDao<SalesStatistic> implements SalesStatisticDao {

    private static volatile SalesStatisticDao instance;

    private SalesStatisticDaoImpl() {
    }

    public static SalesStatisticDao getInstance() {
        if (instance == null) {
            synchronized (SalesStatisticDao.class) {
                if (instance == null) {
                    instance = new SalesStatisticDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<SalesStatistic> findAllSalesStatistic() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM SalesStatistic ORDER BY month ASC").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public SalesStatistic getSalesStatistic(Long id) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.get(SalesStatistic.class,id);
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public SalesStatistic getSalesStatisticByMonth(Month month) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                List<SalesStatistic> list = sessionDB.createQuery("from SalesStatistic where month = :month").setParameter("month",month).list();
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
