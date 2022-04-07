package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.dao.CameraСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.dao.OtherСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.product.CameraСharacteristics;

public class CameraСharacteristicsDaoImpl extends AbstractDao<CameraСharacteristics> implements CameraСharacteristicsDao {

    private static volatile CameraСharacteristicsDao instance;

    private CameraСharacteristicsDaoImpl() {
    }

    public static CameraСharacteristicsDao getInstance() {
        if (instance == null) {
            synchronized (CameraСharacteristicsDao.class) {
                if (instance == null) {
                    instance = new CameraСharacteristicsDaoImpl();
                }
            }
        }
        return instance;
    }

}
