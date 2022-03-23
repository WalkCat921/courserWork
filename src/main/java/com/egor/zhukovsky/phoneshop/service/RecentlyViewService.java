package com.egor.zhukovsky.phoneshop.service;

import com.egor.zhukovsky.phoneshop.model.product.Product;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface RecentlyViewService {
    void add(List<Product> recentlyViewed, Product product);

    List<Product> getRecentlyViewedProducts(HttpSession session);
}