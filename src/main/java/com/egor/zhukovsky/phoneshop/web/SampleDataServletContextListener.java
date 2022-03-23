package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.model.product.SampleProduct;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SampleDataServletContextListener implements ServletContextListener {

    private static final String INIT_PARAM = "createSampleData";

    private ProductDao productDao;

    public SampleDataServletContextListener() {
        this.productDao = ArrayListProductDao.getInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
//        if (Boolean.parseBoolean(event.getServletContext().getInitParameter(INIT_PARAM))) {
//            SampleProduct.createSampleProductsArrayList(productDao);
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
