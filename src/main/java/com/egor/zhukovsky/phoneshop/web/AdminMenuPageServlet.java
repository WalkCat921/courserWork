package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.service.CartService;
import com.egor.zhukovsky.phoneshop.service.impl.CartServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminMenuPageServlet extends HttpServlet {
    private static final String ADMIN_MENU_JSP_PATH = "/WEB-INF/pages/adminMenu.jsp";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ADMIN_MENU_JSP_PATH).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
