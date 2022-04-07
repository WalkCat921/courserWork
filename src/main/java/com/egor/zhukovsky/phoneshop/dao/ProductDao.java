package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import com.egor.zhukovsky.phoneshop.model.sort.SortField;
import com.egor.zhukovsky.phoneshop.model.sort.SortOrder;

import java.util.List;
import java.util.NoSuchElementException;

public interface ProductDao extends DAO<Product> {
    Product getByCode(String code) throws NoSuchElementException, NullPointerException;

    @Override
    List<Product> findAll();

    List<Product> findProductsByQuery(String query);

    void updateStock(Order order);

    List<Product> findProductsByQuerySortFieldAndOrder(String query, SortField sortField, SortOrder sortOrder);
}