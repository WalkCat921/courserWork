package com.egor.zhukovsky.phoneshop.service.impl;

import com.egor.zhukovsky.phoneshop.dao.OrderDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListOrderDao;
import com.egor.zhukovsky.phoneshop.model.cart.Cart;
import com.egor.zhukovsky.phoneshop.model.cart.CartItem;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.order.PaymentMethod;
import com.egor.zhukovsky.phoneshop.service.OrderService;
import org.apache.commons.lang3.SerializationUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private static final Object LOCK = new Object();
    private static final int DELIVERY_COST = 5;

    private static volatile OrderService instance;

    private OrderDao orderDao = ArrayListOrderDao.getInstance();

    public static OrderService getInstance() {
        if (instance == null) {
            synchronized (OrderService.class) {
                if (instance == null) {
                    instance = new OrderServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Order getOrder(Cart cart) {
        synchronized (LOCK) {
            Order order = new Order();

            order.setItemList(SerializationUtils.clone((ArrayList<CartItem>) cart.getItemList()));
            order.setSubtotal(cart.getTotalCost());
            order.setDeliveryCost(calculateDeliveryCost());
            order.setTotal(order.getSubtotal().add(order.getDeliveryCost()));

            return order;
        }
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        synchronized (LOCK) {
            return Arrays.asList(PaymentMethod.values());
        }
    }

    @Override
    public void placeOrder(Order order) {
        synchronized (LOCK) {
            order.setSecureId(UUID.randomUUID().toString());
            orderDao.save(order);
        }
    }

    private BigDecimal calculateDeliveryCost() {
        return new BigDecimal(DELIVERY_COST);
    }
}