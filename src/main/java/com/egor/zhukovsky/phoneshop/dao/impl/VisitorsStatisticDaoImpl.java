package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.VisitorsStatisticDao;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.util.List;

public class VisitorsStatisticDaoImpl extends AbstractDao<VisitorsStatistic> implements VisitorsStatisticDao {

    private static volatile VisitorsStatisticDao instance;

    private VisitorsStatisticDaoImpl() {
    }

    public static VisitorsStatisticDao getInstance() {
        if (instance == null) {
            synchronized (VisitorsStatisticDao.class) {
                if (instance == null) {
                    instance = new VisitorsStatisticDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<VisitorsStatistic> findAllVisitorsStatistic() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM VisitorsStatistic ORDER BY date ASC").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }



    @Override
    public VisitorsStatistic getVisitorsStatistic(Long id) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.get(VisitorsStatistic.class,id);
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public VisitorsStatistic getVisitorsStatisticByDate(LocalDate date) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                List<VisitorsStatistic> list = sessionDB.createQuery("from VisitorsStatistic where date = :date").setParameter("date",date).list();
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
