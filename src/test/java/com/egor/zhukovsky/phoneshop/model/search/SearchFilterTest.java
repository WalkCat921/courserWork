package com.egor.zhukovsky.phoneshop.model.search;

import com.egor.zhukovsky.phoneshop.model.product.SampleProduct;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import org.junit.Before;
import org.junit.Test;

import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchFilterTest {
    private ProductDao productDao;
    private Currency USD;


    @Before
    public void setUp() {
        productDao = ArrayListProductDao.getInstance();
        USD = Currency.getInstance("USD");
        SampleProduct.createSampleProductsArrayList(productDao);
    }

    @Test
    public void testFilteredListByQuery() {
        List<Product> products = productDao.findAll();
        Product iPhone = productDao.getByCode("iphone");
        Product iPhone6 = productDao.getByCode("iphone6");

        products = SearchFilter.getFilteredListByQuery(products, "Apple iPhone");

        assertEquals(products.get(0), iPhone);
        assertEquals(products.get(1), iPhone6);
    }
}