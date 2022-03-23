package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.cart.Cart;
import com.egor.zhukovsky.phoneshop.exception.OutOfStockException;

import javax.servlet.http.HttpSession;

public interface CartService {
    Cart getCart(HttpSession session);

    void add(Cart cart, String productCode, int quantity) throws OutOfStockException, IllegalArgumentException, NullPointerException;

    void update(Cart cart, String productCode, int quantity) throws OutOfStockException, IllegalArgumentException, NullPointerException;

    void delete(Cart cart, String productCode);

    void clear(Cart cart);
}