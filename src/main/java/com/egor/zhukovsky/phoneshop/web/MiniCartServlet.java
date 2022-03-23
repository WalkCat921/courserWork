package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.service.impl.CartServiceImpl;
import com.egor.zhukovsky.phoneshop.service.CartService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MiniCartServlet extends HttpServlet {

    private static final String CART_ATTRIBUTE = "cart";
    private static final String MINI_CART_JSP_PATH = "/WEB-INF/pages/miniCart.jsp";

    private CartService cartService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = CartServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(CART_ATTRIBUTE, cartService.getCart(request.getSession()));
        request.getRequestDispatcher(MINI_CART_JSP_PATH).include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}