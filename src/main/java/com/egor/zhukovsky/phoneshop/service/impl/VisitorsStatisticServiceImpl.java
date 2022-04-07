package com.egor.zhukovsky.phoneshop.service.impl;

import com.egor.zhukovsky.phoneshop.dao.VisitorsStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.impl.VisitorsStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;
import com.egor.zhukovsky.phoneshop.service.VisitorsStatisticService;

import java.time.LocalDate;
import java.util.List;

public class VisitorsStatisticServiceImpl implements VisitorsStatisticService {

    private static volatile VisitorsStatisticService instance;

    private VisitorsStatisticDao statisticDao;

    private VisitorsStatisticServiceImpl() {
        statisticDao = VisitorsStatisticDaoImpl.getInstance();
    }

    public static VisitorsStatisticService getInstance() {
        if (instance == null) {
            synchronized (VisitorsStatisticService.class) {
                if (instance == null) {
                    instance = new VisitorsStatisticServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveVisitorStatistic(VisitorsStatistic visitorsStatistic) {
        statisticDao.save(visitorsStatistic);
    }

    @Override
    public VisitorsStatistic getVisitorsStatisticByDate(LocalDate date) {
        return statisticDao.getVisitorsStatisticByDate(date);
    }

    @Override
    public void updateVisitorStatistic(VisitorsStatistic visitorsStatistic) {
        statisticDao.update(visitorsStatistic);
    }

    @Override
    public List<VisitorsStatistic> getAllVisitorStatistic() {
        return statisticDao.findAllVisitorsStatistic();
    }
}
