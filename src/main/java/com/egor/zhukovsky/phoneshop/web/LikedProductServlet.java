package com.egor.zhukovsky.phoneshop.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LikedProductServlet extends HttpServlet {

    private static final String LIKED_PRODUCTS_ATTRIBUTE = "LikedProductArray";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String unlikedProductCode = request.getParameter("unlikedCode");
        List<String> likedProduct = (List<String>) request.getSession().getAttribute(LIKED_PRODUCTS_ATTRIBUTE);
        if (likedProduct==null){
            return;
        }
        if (unlikedProductCode!=null){
            if (likedProduct.contains(unlikedProductCode))
            likedProduct.remove(unlikedProductCode);
            request.getSession().setAttribute("LikedProductArray",likedProduct);
        }
        System.out.println(likedProduct);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> likedProduct = (List<String>) request.getSession().getAttribute(LIKED_PRODUCTS_ATTRIBUTE);
        if (likedProduct==null){
            likedProduct = new ArrayList<>();
        }
        String likedProductCode = request.getParameter("likedCode");
        if (likedProductCode!=null){
            if (likedProduct.size()!=3){
                likedProduct.add(likedProductCode);
            } else {
                likedProduct.remove(likedProduct.get(2));
                likedProduct.add(likedProductCode);
            }
        }
        request.getSession().setAttribute("LikedProductArray",likedProduct);
        System.out.println(likedProduct);
    }
}
