package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.statistic.PriceStatistic;

import java.time.Month;
import java.util.List;

public interface PriceStatisticService {
    void savePriceStatistic(PriceStatistic salesStatistic);

    PriceStatistic getPriceStatisticByMonth(Month month);

    void updatePriceStatistic(PriceStatistic salesStatistic);

    List<PriceStatistic> getAllPriceStatistic();
}
