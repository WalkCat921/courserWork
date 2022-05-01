package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.model.search.SearchFilter;
import com.egor.zhukovsky.phoneshop.model.sort.SortComparator;
import com.egor.zhukovsky.phoneshop.model.sort.SortField;
import com.egor.zhukovsky.phoneshop.model.sort.SortOrder;
import org.hibernate.Session;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ArrayListProductDao extends AbstractDao<Product> implements ProductDao {

    private static volatile ProductDao instance;

    private ArrayListProductDao() {
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            synchronized (ProductDao.class) {
                if (instance == null) {
                    instance = new ArrayListProductDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Product> findAll() {
        return super.findAll().stream()
                .filter(product -> product.getPrice() != null)
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Product getByCode(String code) throws NoSuchElementException, NullPointerException {
        synchronized (LOCK) {
            sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
            synchronized (LOCK) {
                try{
                    sessionDB.beginTransaction();
                    List<Product> product = sessionDB.createQuery("from Product where code = :code").setParameter("code",code).list();
                    if (product.isEmpty()){
                        return null;
                    }
                    return product.get(0);
                } finally {
                    sessionDB.getTransaction().commit();
                    sessionDB.close();
                }
            }
        }
    }

    @Override
    public List<Product> findProductsByQuery(String query) {
        synchronized (LOCK) {
            if (query != null && !query.trim().isEmpty()) {
                return SearchFilter.getFilteredListByQuery(findAll(), query);
            } else {
                return findAll();
            }
        }
    }

    @Override
    public void updateStock(Order order) {
        order.getItemList().stream().forEach(cartItem -> {
            findAll().stream().forEach(product -> {
                if (cartItem.getProduct().getCode().equals(product.getCode())) {
                    product.setStock(product.getStock() - cartItem.getQuantity());
                    super.update(product);
                }
            });
        });
    }

    @Override
    public List<Product> findProductsByQuerySortFieldAndOrder(String query, SortField sortField, SortOrder sortOrder) {
        synchronized (LOCK) {
            SortComparator sortComparator = new SortComparator();
            return findProductsByQuery(query).stream()
                    .sorted(sortComparator.getSortFieldOrderComparator(sortField, sortOrder))
                    .collect(Collectors.toList());
        }
    }
}