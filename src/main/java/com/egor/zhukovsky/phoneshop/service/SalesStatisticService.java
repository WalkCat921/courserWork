package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface SalesStatisticService {
    void saveSalesStatistic(SalesStatistic salesStatistic);

    SalesStatistic getSalesStatisticByMonth(Month month);

    void updateSalesStatistic(SalesStatistic salesStatistic);

    List<SalesStatistic> getAllSalesStatistic();
}
