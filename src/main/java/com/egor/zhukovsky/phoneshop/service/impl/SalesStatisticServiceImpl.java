package com.egor.zhukovsky.phoneshop.service.impl;

import com.egor.zhukovsky.phoneshop.dao.SalesStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.VisitorsStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.impl.SalesStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.dao.impl.VisitorsStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.service.SalesStatisticService;
import com.egor.zhukovsky.phoneshop.service.VisitorsStatisticService;

import java.time.Month;
import java.util.List;

public class SalesStatisticServiceImpl implements SalesStatisticService {

    private static volatile SalesStatisticService instance;

    private SalesStatisticDao salesStatisticDao;

    private SalesStatisticServiceImpl() {
        salesStatisticDao = SalesStatisticDaoImpl.getInstance();
    }

    public static SalesStatisticService getInstance() {
        if (instance == null) {
            synchronized (SalesStatisticService.class) {
                if (instance == null) {
                    instance = new SalesStatisticServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveSalesStatistic(SalesStatistic salesStatistic) {
        salesStatisticDao.save(salesStatistic);
    }

    @Override
    public SalesStatistic getSalesStatisticByMonth(Month month) {
        return salesStatisticDao.getSalesStatisticByMonth(month);
    }

    @Override
    public void updateSalesStatistic(SalesStatistic salesStatistic) {
        salesStatisticDao.update(salesStatistic);
    }

    @Override
    public List<SalesStatistic> getAllSalesStatistic() {
        return salesStatisticDao.findAllSalesStatistic();
    }
}
