package com.egor.zhukovsky.phoneshop.web;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.ShopDao;
import com.egor.zhukovsky.phoneshop.dao.VisitorsStatisticDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.SalesStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.dao.impl.ShopDaoImpl;
import com.egor.zhukovsky.phoneshop.dao.impl.VisitorsStatisticDaoImpl;
import com.egor.zhukovsky.phoneshop.model.cart.Cart;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.service.CartService;
import com.egor.zhukovsky.phoneshop.service.OrderService;
import com.egor.zhukovsky.phoneshop.service.SalesStatisticService;
import com.egor.zhukovsky.phoneshop.service.impl.CartServiceImpl;
import com.egor.zhukovsky.phoneshop.service.impl.OrderServiceImpl;
import com.egor.zhukovsky.phoneshop.service.impl.SalesStatisticServiceImpl;
import com.egor.zhukovsky.phoneshop.validator.FormValidator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class CheckoutPageServlet extends HttpServlet {

    private static final String ERROR_SESSION_ATTRIBUTE = "ErrorSessionCheckoutPage";
    private static final String ERROR_ATTRIBUTE = "errors";
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String PHONE_PARAM = "phone";
    private static final String CART_ATTRIBUTE = "cart";
    private static final String DELIVERY_DATE_PARAM = "deliveryDate";
    private static final String DELIVERY_ADDRESS_PARAM = "deliveryAddress";
    private static final String SHOP_ADDRESS_PARAM = "shopAddresses";
    private static final String CACHE_HEADER = "Cache-Control";
    private static final String CACHE_HEADER_PARAMETERS = "no-cache, no-store, must-revalidate";
    private static final String ORDER_ATTRIBUTE = "order";
    private static final String PAYMENT_METHOD_PARAM = "paymentMethod";
    private static final String CHECKOUT_JSP_PATH = "/WEB-INF/pages/checkout.jsp";

    private CartService cartService;
    private OrderService orderService;
    private ProductDao productDao;
    private ShopDao shopDao;
    private SalesStatisticService salesStatisticService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = CartServiceImpl.getInstance();
        orderService = OrderServiceImpl.getInstance();
        productDao = ArrayListProductDao.getInstance();
        shopDao = ShopDaoImpl.getInstance();
        salesStatisticService = SalesStatisticServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCart(request.getSession());
        if (cart.getItemList().isEmpty()) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        setAttributeFromSession(request, ERROR_SESSION_ATTRIBUTE, ERROR_ATTRIBUTE);
        request.setAttribute(CART_ATTRIBUTE, cart);
        request.setAttribute(ORDER_ATTRIBUTE, orderService.getOrder(cart));
        request.setAttribute(SHOP_ADDRESS_PARAM,shopDao.findAllShop());
        response.setHeader(CACHE_HEADER, CACHE_HEADER_PARAMETERS);
        request.setAttribute(PAYMENT_METHOD_PARAM, orderService.getPaymentMethods());
        request.getRequestDispatcher(CHECKOUT_JSP_PATH).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCart(request.getSession());
        Order order = orderService.getOrder(cart);
        Map<String, String> errors = new HashMap<>();
        FormValidator.validateOrderForm(request.getParameter(FIRST_NAME_PARAM), FIRST_NAME_PARAM, errors,
                order::setFirstName);
        FormValidator.validateOrderForm(request.getParameter(LAST_NAME_PARAM), LAST_NAME_PARAM, errors,
                order::setLastName);
        FormValidator.validateOrderForm(request.getParameter(PHONE_PARAM), PHONE_PARAM, errors,
                order::setPhone);
        FormValidator.validateOrderForm(request.getParameter(DELIVERY_DATE_PARAM), DELIVERY_DATE_PARAM, errors,
                order::setDeliveryDate);
        FormValidator.validateOrderForm(request.getParameter(DELIVERY_ADDRESS_PARAM), DELIVERY_ADDRESS_PARAM, errors,
                order::setDeliveryAddress);
        FormValidator.validateOrderForm(request.getParameter(PAYMENT_METHOD_PARAM), PAYMENT_METHOD_PARAM, errors,
                order::setPaymentMethod);
        if (errors.isEmpty()) {
            orderService.placeOrder(order);
            //TODO write salesstatistic
            SalesStatistic salesStatistic = salesStatisticService.getSalesStatisticByMonth(LocalDate.now().getMonth());
            if (salesStatistic == null){
                salesStatistic = new SalesStatistic(Long.parseLong(String.valueOf(cart.getTotalQuantity())),LocalDate.now().getMonth());
                salesStatisticService.saveSalesStatistic(salesStatistic);
            } else {
                salesStatistic.setCountSales(salesStatistic.getCountSales()+Long.parseLong(String.valueOf(cart.getTotalQuantity())));
                salesStatisticService.updateSalesStatistic(salesStatistic);
            }
            productDao.updateStock(order);
            cartService.clear(cartService.getCart(request.getSession()));
            response.sendRedirect(String.format("%s/order/overview/%s",
                    request.getContextPath(), order.getSecureId()));
        } else {
            setValueInSession(request, ERROR_SESSION_ATTRIBUTE, errors);
            response.sendRedirect(String.format("%s/checkout", request.getContextPath()));
        }
    }

    private void setAttributeFromSession(HttpServletRequest request, String sessionAttribute,
                                         String attribute) {
        if (request.getSession().getAttribute(sessionAttribute) != null) {
            request.setAttribute(attribute, request.getSession().getAttribute(sessionAttribute));
            request.getSession().removeAttribute(sessionAttribute);
        }
    }

    private void setValueInSession(HttpServletRequest request, String sessionAttribute, Object object) {
        request.getSession().setAttribute(sessionAttribute, object);
    }
}