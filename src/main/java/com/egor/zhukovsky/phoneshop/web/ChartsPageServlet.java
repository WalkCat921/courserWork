package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.service.SalesStatisticService;
import com.egor.zhukovsky.phoneshop.service.VisitorsStatisticService;
import com.egor.zhukovsky.phoneshop.service.impl.SalesStatisticServiceImpl;
import com.egor.zhukovsky.phoneshop.service.impl.VisitorsStatisticServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChartsPageServlet extends HttpServlet {

    private static final String CACHE_HEADER = "Cache-Control";
    private static final String CACHE_HEADER_PARAMETERS = "no-cache, no-store, must-revalidate";
    private static final String PRODUCT_TABLE_ATTRIBUTE = "products";
    private static final String ADMIN_MENU_JSP_PATH = "/WEB-INF/startbootstrap-sb-admin-gh-pages/html/charts.jsp";
    private ProductDao productDao;
    private VisitorsStatisticService statisticService;
    private SalesStatisticService salesStatisticService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDao = ArrayListProductDao.getInstance();
        statisticService = VisitorsStatisticServiceImpl.getInstance();
        salesStatisticService = SalesStatisticServiceImpl.getInstance();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(PRODUCT_TABLE_ATTRIBUTE,productDao.findAll());
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        request.setAttribute("visitorsStatistic",mapper.writeValueAsString(statisticService.getAllVisitorStatistic()));
        request.setAttribute("salesStatistic",mapper.writeValueAsString(salesStatisticService.getAllSalesStatistic()));
        response.setHeader(CACHE_HEADER,CACHE_HEADER_PARAMETERS);
        request.getRequestDispatcher(ADMIN_MENU_JSP_PATH).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}