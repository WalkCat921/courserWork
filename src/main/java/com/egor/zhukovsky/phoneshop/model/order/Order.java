package com.egor.zhukovsky.phoneshop.model.order;

import com.egor.zhukovsky.phoneshop.model.cart.Cart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class Order extends Cart {
    private Long id;
    private String secureId;
    private BigDecimal subtotal;
    private BigDecimal deliveryCost;
    private Currency currency = Currency.getInstance("USD");

    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate deliveryDate;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSecureId() {
        return secureId;
    }

    public void setSecureId(String secureId) {
        this.secureId = secureId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", subtotal=" + subtotal +
                ", deliveryCost=" + deliveryCost +
                ", currency=" + currency +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentMethod=" + paymentMethod +
                "} " + super.toString();
    }
}