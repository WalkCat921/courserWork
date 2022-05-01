package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.statistic.PriceStatistic;
import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface PriceStatisticDao extends DAO<PriceStatistic> {
    List<PriceStatistic> findAllPriceStatistic();
    PriceStatistic getPriceStatistic(Long id);
    PriceStatistic getPriceStatisticByMonth(Month month);
}
