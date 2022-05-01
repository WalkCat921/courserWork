package com.egor.zhukovsky.phoneshop.validator;

import com.egor.zhukovsky.phoneshop.model.order.Order;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FormValidatorTest {

    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String PHONE_PARAM = "phone";
    private static final String DELIVERY_DATE_PARAM = "deliveryDate";
    private static final String DELIVERY_ADDRESS_PARAM = "deliveryAddress";
    private static final String PAYMENT_METHOD_PARAM = "paymentMethod";
    private Map<String,String> errors;
    private Order order;

    @Before
    public void setup(){
        order = new Order();
        errors = new HashMap<>();
    }

    @Test
    public void testValidateFirstNameSuccess() {
        final String firstName = "Egor";

        OrderFormValidator.validateOrderForm(firstName,FIRST_NAME_PARAM,errors,order::setFirstName);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getFirstName());
    }

    @Test
    public void testValidateLastNameSuccess() {
        final String lastName = "Tapok";

        OrderFormValidator.validateOrderForm(lastName,LAST_NAME_PARAM,errors,order::setLastName);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getLastName());
    }

    @Test
    public void testValidatePhoneSuccess() {
        final String phone = "375293451232";

        OrderFormValidator.validateOrderForm(phone,PHONE_PARAM,errors,order::setPhone);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getPhone());
    }

    @Test
    public void testValidateDeliveryDateSuccess() {
        final String currentDate = LocalDate.now().toString();

        OrderFormValidator.validateOrderForm(currentDate,DELIVERY_DATE_PARAM,errors,order::setDeliveryDate);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getDeliveryDate());
    }

    @Test
    public void testValidateDeliveryAddressSuccess() {
        final String address = "st. Test 13-2, Test";

        OrderFormValidator.validateOrderForm(address,DELIVERY_ADDRESS_PARAM,errors,order::setDeliveryAddress);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getDeliveryAddress());
    }

    @Test
    public void testValidatePaymentMethodSuccess() {
        final String paymentMethod = "CASH";

        OrderFormValidator.validateOrderForm(paymentMethod,PAYMENT_METHOD_PARAM,errors,order::setPaymentMethod);

        assertTrue(errors.isEmpty());
        assertNotNull(order.getPaymentMethod());
    }

    @Test
    public void testValidateNullAddErrorInMap() {
        OrderFormValidator.validateOrderForm(null,PAYMENT_METHOD_PARAM,errors,order::setPaymentMethod);

        assertTrue(!errors.isEmpty());
    }

    @Test
    public void testValidateEmptyAddErrorInMap() {
        OrderFormValidator.validateOrderForm("",PAYMENT_METHOD_PARAM,errors,order::setPaymentMethod);

        assertTrue(!errors.isEmpty());
    }

    @Test
    public void testValidateWrongFirstLastNameAddErrorInMap() {
        final String wrongFirstName = "sj=-ndiw";
        final String wrongLastName = "Zi92jd92";

        OrderFormValidator.validateOrderForm(wrongFirstName,FIRST_NAME_PARAM,errors,order::setFirstName);
        OrderFormValidator.validateOrderForm(wrongLastName,LAST_NAME_PARAM,errors,order::setLastName);

        assertTrue(!errors.isEmpty());
        assertTrue(errors.keySet().contains(FIRST_NAME_PARAM));
        assertTrue(errors.keySet().contains(LAST_NAME_PARAM));
    }

    @Test
    public void testValidateWrongPhoneAddErrorInMap() {
        final String wrongPhone = "462hgebw72gd";

        OrderFormValidator.validateOrderForm(wrongPhone,PHONE_PARAM,errors,order::setPhone);

        assertTrue(!errors.isEmpty());
        assertTrue(errors.keySet().contains(PHONE_PARAM));
    }

    @Test
    public void testValidateWrongDeliveryDateAddErrorInMap() {
        final String wrongDate = LocalDate.now().plusWeeks(3).toString();

        OrderFormValidator.validateOrderForm(wrongDate,DELIVERY_DATE_PARAM,errors,order::setDeliveryDate);

        assertTrue(!errors.isEmpty());
        assertTrue(errors.keySet().contains(DELIVERY_DATE_PARAM));
    }

    @Test
    public void testValidateWrongDeliveryAddressAddErrorInMap() {
        final String wrongAddress = "test 23 2 1";

        OrderFormValidator.validateOrderForm(wrongAddress,DELIVERY_ADDRESS_PARAM,errors,order::setDeliveryAddress);

        assertTrue(!errors.isEmpty());
        assertTrue(errors.keySet().contains(DELIVERY_ADDRESS_PARAM));
    }

    @Test
    public void testValidateWrongPaymentMethodAddErrorInMap() {
        final String wrongPayment = "FREE";

        OrderFormValidator.validateOrderForm(wrongPayment,PAYMENT_METHOD_PARAM,errors,order::setPaymentMethod);

        assertTrue(!errors.isEmpty());
        assertTrue(errors.keySet().contains(PAYMENT_METHOD_PARAM));
    }
}