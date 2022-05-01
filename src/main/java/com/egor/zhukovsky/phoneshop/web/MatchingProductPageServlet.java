package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListOrderDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import com.egor.zhukovsky.phoneshop.service.CartService;
import com.egor.zhukovsky.phoneshop.service.RecentlyViewService;
import com.egor.zhukovsky.phoneshop.service.impl.CartServiceImpl;
import com.egor.zhukovsky.phoneshop.service.impl.RecentlyViewServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchingProductPageServlet extends HttpServlet {


    private static final String RECENTLY_VIEW_ATTRIBUTE = "recentlyView";
    private static final String LIKED_PRODUCTS_ATTRIBUTE = "LikedProductArray";
    private static final String MATCHING_JSP_PATH = "/WEB-INF/pages/matchingProducts.jsp";
    private static final String CART_ATTRIBUTE = "cart";
    private ProductDao productDao;
    private CartService cartService;
    private RecentlyViewService recentlyViewService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        productDao=ArrayListProductDao.getInstance();
        cartService = CartServiceImpl.getInstance();
        recentlyViewService = RecentlyViewServiceImpl.getInstance();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> likedProducts = (List<String>) request.getSession().getAttribute(LIKED_PRODUCTS_ATTRIBUTE);
        List<Product> products = new ArrayList<>();
        for (String code : likedProducts){
            products.add(productDao.getByCode(code));
        }
        request.setAttribute("likedProducts",products);
        request.setAttribute(CART_ATTRIBUTE,cartService.getCart(request.getSession()));
        request.setAttribute(RECENTLY_VIEW_ATTRIBUTE,
                recentlyViewService.getRecentlyViewedProducts(request.getSession()));
        request.getRequestDispatcher(MATCHING_JSP_PATH).forward(request,response);
    }
    //todo add to cart from matching page

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
