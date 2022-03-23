package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.service.impl.CartServiceImpl;
import com.egor.zhukovsky.phoneshop.model.cart.Cart;
import com.egor.zhukovsky.phoneshop.service.CartService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCartItemServlet extends HttpServlet {

    private CartService cartService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = CartServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCart(request.getSession());
        cartService.delete(cart, request.getPathInfo().substring(1));
        response.sendRedirect(String.format("%s/cart?message=Cart item removed successfully", request.getContextPath()));
    }
}