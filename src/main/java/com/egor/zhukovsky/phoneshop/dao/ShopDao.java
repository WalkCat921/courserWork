package com.egor.zhukovsky.phoneshop.dao;

import com.egor.zhukovsky.phoneshop.model.shop.Shop;

import java.util.List;

public interface ShopDao extends DAO<Shop> {

    List<Shop> findAllShop();
}
