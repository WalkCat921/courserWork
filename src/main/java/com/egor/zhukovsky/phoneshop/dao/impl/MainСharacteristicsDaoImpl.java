package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.dao.MainСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.product.MainСharacteristics;

public class MainСharacteristicsDaoImpl extends AbstractDao<MainСharacteristics> implements MainСharacteristicsDao {

    private static volatile MainСharacteristicsDao instance;

    private MainСharacteristicsDaoImpl() {
    }

    public static MainСharacteristicsDao getInstance() {
        if (instance == null) {
            synchronized (MainСharacteristicsDao.class) {
                if (instance == null) {
                    instance = new MainСharacteristicsDaoImpl();
                }
            }
        }
        return instance;
    }

}
