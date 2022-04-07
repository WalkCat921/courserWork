package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import java.util.List;

public interface DAO<T extends Item> {
    T get(Long id);

    List<T> findAll();

    void update(T object);

    void save(T object);

    void delete(Long id);
}
