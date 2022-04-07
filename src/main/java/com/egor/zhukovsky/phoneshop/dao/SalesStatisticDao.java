package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface SalesStatisticDao extends DAO<SalesStatistic> {
    List<SalesStatistic> findAllSalesStatistic();
    SalesStatistic getSalesStatistic(Long id);
    SalesStatistic getSalesStatisticByMonth(Month date);
}