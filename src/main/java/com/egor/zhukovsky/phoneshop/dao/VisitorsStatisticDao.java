package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.util.List;

public interface VisitorsStatisticDao extends DAO<VisitorsStatistic> {
    List<VisitorsStatistic> findAllVisitorsStatistic();
    VisitorsStatistic getVisitorsStatistic(Long id);
    VisitorsStatistic getVisitorsStatisticByDate(LocalDate date);
}
