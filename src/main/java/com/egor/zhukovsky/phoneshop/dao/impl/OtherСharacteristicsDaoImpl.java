package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.dao.MainСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.dao.OtherСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.product.OtherСharacteristics;

public class OtherСharacteristicsDaoImpl extends AbstractDao<OtherСharacteristics> implements OtherСharacteristicsDao {

    private static volatile OtherСharacteristicsDao instance;

    private OtherСharacteristicsDaoImpl() {
    }

    public static OtherСharacteristicsDao getInstance() {
        if (instance == null) {
            synchronized (OtherСharacteristicsDao.class) {
                if (instance == null) {
                    instance = new OtherСharacteristicsDaoImpl();
                }
            }
        }
        return instance;
    }

}
