package com.egor.zhukovsky.phoneshop.web.admin;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

public class DeleteProductServlet extends HttpServlet {

    private static final String PRODUCT_ID_PARAM = "id";
    private static final String CACHE_HEADER = "Cache-Control";
    private static final String CACHE_HEADER_PARAMETERS = "no-cache, no-store, must-revalidate";
    private static final String PRODUCT_TABLE_ATTRIBUTE = "products";
//    private static final String ADMIN_MENU_JSP_PATH = "/WEB-INF/startbootstrap-sb-admin-gh-pages/html/adminMenu.jsp";
    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDao = ArrayListProductDao.getInstance();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader(CACHE_HEADER,CACHE_HEADER_PARAMETERS);
        response.sendRedirect(String.format("/admin/menu/tables"));
//        request.getRequestDispatcher(ADMIN_MENU_JSP_PATH).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NumberFormat format = NumberFormat.getInstance(request.getLocale());
            productDao.delete(format.parse(request.getParameter(PRODUCT_ID_PARAM)).longValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        doGet(request,response);
    }

}