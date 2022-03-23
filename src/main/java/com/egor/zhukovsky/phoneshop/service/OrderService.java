package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.cart.Cart;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.order.PaymentMethod;

import java.util.List;

public interface OrderService {
    Order getOrder(Cart cart);

    List<PaymentMethod> getPaymentMethods();

    void placeOrder(Order order);
}