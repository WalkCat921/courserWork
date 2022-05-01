package com.egor.zhukovsky.phoneshop.service.impl;

import com.egor.zhukovsky.phoneshop.dao.PriceStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.SalesStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.impl.PriceStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.dao.impl.SalesStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.model.statistic.PriceStatistic;
import com.egor.zhukovsky.phoneshop.service.PriceStatisticService;
import com.egor.zhukovsky.phoneshop.service.SalesStatisticService;

import java.time.Month;
import java.util.List;

public class PriceStatisticServiceImpl implements PriceStatisticService {

    private static volatile PriceStatisticService instance;

    private PriceStatisticDao priceStatisticDao;

    private PriceStatisticServiceImpl() {
        priceStatisticDao = PriceStatisticDaoImpl.getInstance();
    }

    public static PriceStatisticService getInstance() {
        if (instance == null) {
            synchronized (PriceStatisticService.class) {
                if (instance == null) {
                    instance = new PriceStatisticServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void savePriceStatistic(PriceStatistic priceStatistic) {
        priceStatisticDao.save(priceStatistic);
    }

    @Override
    public PriceStatistic getPriceStatisticByMonth(Month month) {
        return priceStatisticDao.getPriceStatisticByMonth(month);
    }

    @Override
    public void updatePriceStatistic(PriceStatistic priceStatistic) {
        priceStatisticDao.update(priceStatistic);
    }

    @Override
    public List<PriceStatistic> getAllPriceStatistic() {
        return priceStatisticDao.findAllPriceStatistic();
    }
}
