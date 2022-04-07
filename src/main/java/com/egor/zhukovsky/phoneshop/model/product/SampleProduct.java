package com.egor.zhukovsky.phoneshop.model.product;

import com.egor.zhukovsky.phoneshop.dao.DAO;
import com.egor.zhukovsky.phoneshop.dao.MainСharacteristicsDao;
import com.egor.zhukovsky.phoneshop.dao.OrderDao;
import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListOrderDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.MainСharacteristicsDaoImpl;
import com.egor.zhukovsky.phoneshop.dao.impl.ShopDaoImpl;
import com.egor.zhukovsky.phoneshop.model.order.Order;
import com.egor.zhukovsky.phoneshop.model.price.PriceHistory;
import com.egor.zhukovsky.phoneshop.model.shop.Shop;
import com.egor.zhukovsky.phoneshop.model.statistic.SalesStatistic;
import com.egor.zhukovsky.phoneshop.service.SalesStatisticService;
import com.egor.zhukovsky.phoneshop.service.impl.SalesStatisticServiceImpl;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SampleProduct {

    private static final Currency USD = Currency.getInstance("USD");

//    private static List<LocalDate> createLocalDateList() {
//        List<LocalDate> localDates = new ArrayList<>();
//        LocalDate localDate = LocalDate.now();
//        localDate.datesUntil(localDate.minus(3, ChronoUnit.YEARS), Period.ofDays(-365)).forEach(id -> {
//            localDates.add(id);
//        });
//        return localDates;
//    }
//
//    private static List<BigDecimal> createPriceList(@NonNull BigDecimal productPrice) throws NullPointerException {
//        return Stream.iterate(productPrice, price -> {
//            BigDecimal min = new BigDecimal(String.valueOf(price.divide(BigDecimal.valueOf(2))));
//            BigDecimal max = min.add(new BigDecimal(String.valueOf(min.multiply(BigDecimal.valueOf(2)))));
//            BigDecimal range = max.subtract(min);
//            BigDecimal result = min.add(range.multiply(new BigDecimal(Math.random())));
//            return result;
//        }).limit(4).collect(Collectors.toList());
//    }
//
//    public static PriceHistory createPriceHistory(BigDecimal price) {
//        return new PriceHistory(createLocalDateList(), createPriceList(price));
//    }

    public static void createSampleProductsArrayList(ProductDao productDao) throws NullPointerException {
//        productDao.save(new Product("sgs22", "Samsung Galaxy S22", new BigDecimal(1385), USD, 100, "https://mobistore.by/files/products/1/samsung-galaxy-s22-5g-128gb-pr27689_3.800x600w.jpg"));
//        productDao.save(new Product("sgzflip3", "Samsung Galaxy Z Flip 3", new BigDecimal(1158), USD, 15, "https://mobistore.by/files/products/1/samsung-galaxy-z-flip-3-5g-256gb-pr22223_15.800x600w.jpg"));
//        productDao.save(new Product("h50", "Honor 50", new BigDecimal(531), USD, 5, "https://mobistore.by/files/products/1/honor-50-256gb-pr19967_4.800x600w.jpg"));
//        productDao.save(new Product("xiaomirn11s", "Xiaomi Redmi Note 11S", new BigDecimal(435), USD, 10, "https://mobistore.by/files/products/1/xiaomi-redmi-note-11s-64gb-pr27600.800x600w.jpg"));
//        productDao.save(new Product("sgs21fe", "Samsung Galaxy S21 FE", new BigDecimal(893), USD, 30, "https://mobistore.by/files/products/1/samsung-galaxy-s21-fe-5g-128gb-pr27077_16.800x600w.jpg"));
//        productDao.save(new Product("xiaomipx3", "Xiaomi Poco X3 Pro", new BigDecimal(376), USD, 3, "https://mobistore.by/files/products/1/xiaomi-poco-x3-pro-128gb-pr16339.800x600w.jpg"));
//        productDao.save(new Product("iphone13", "Apple iPhone 13", new BigDecimal(1329), USD, 30, "https://mobistore.by/files/products/1/apple-iphone-13-128gb-pr23370_1.800x600w.jpg"));
//        productDao.save(new Product("iphone13pro", "Apple iPhone 13 Pro", new BigDecimal(1502), USD, 100, "https://mobistore.by/files/products/1/apple-iphone-13-pro-128gb-pr23378_9.800x600w.jpg"));
//        productDao.save(new Product("xiaomimi11l", "Xiaomi Mi 11 Lite", new BigDecimal(440), USD, 100, "https://mobistore.by/files/products/1/xiaomi-mi-11-lite-5g-ne-128gb-pr23556.800x600w.jpg"));
//        productDao.save(new Product("sgs21", "Samsung Galaxy S21", new BigDecimal(926), USD, 30, "https://mobistore.by/files/products/1/samsung-galaxy-s21-256gb-pr15018_3.800x600w.jpg"));
//        productDao.save(new Product("realme8", "Realme 8", new BigDecimal(322), USD, 20, "https://mobistore.by/files/products/1/realme-8-128gb-pr16973_5.800x600w.jpg"));
//        productDao.save(new Product("sga32", "Samsung Galaxy A32", new BigDecimal(326), USD, 30, "https://mobistore.by/files/products/1/samsung-galaxy-a32-64gb-pr15897_1.800x600w.jpg"));
    }
//
//    public static void main(String[] args) {
//        ProductDao productDao = ArrayListProductDao.getInstance();
//        createSampleProductsArrayList(productDao);
//    }

//    public static void main(String[] args) {
//        OrderDao orderDao = ArrayListOrderDao.getInstance();
//        Order order = new Order(1L,"secureId");
//        orderDao.save(order);
//    }

//    public static void main(String[] args) {
//        MainСharacteristicsDao mainСharacteristicsDao = MainСharacteristicsDaoImpl.getInstance();
//        MainСharacteristics main = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main2 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main3 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main4 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main5 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main6 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main7 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main8 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main9 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        MainСharacteristics main10 = new MainСharacteristics(2021,"Android","Android 11","6.7\"");
//        mainСharacteristicsDao.save(main);
//    }
}