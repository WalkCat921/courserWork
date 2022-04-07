package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.util.List;

public interface VisitorsStatisticService {
    void saveVisitorStatistic(VisitorsStatistic visitorsStatistic);

    VisitorsStatistic getVisitorsStatisticByDate(LocalDate date);

    void updateVisitorStatistic(VisitorsStatistic visitorsStatistic);

    List<VisitorsStatistic> getAllVisitorStatistic();
}
