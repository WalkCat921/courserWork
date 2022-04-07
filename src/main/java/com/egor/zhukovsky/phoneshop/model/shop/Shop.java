package com.egor.zhukovsky.phoneshop.model.shop;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "shop")
public class Shop extends Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "rate")
    private int rate;
    @Column(name = "timework")
    private String timeWork;

    public Shop() {
    }

    public Shop(String address, String phone, int rate, String timeWork) {
        this.address = address;
        this.phone = phone;
        this.rate = rate;
        this.timeWork = timeWork;
    }

    public Shop(Long id, String address, String phone, int rate, String timeWork) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.rate = rate;
        this.timeWork = timeWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(String timeWork) {
        this.timeWork = timeWork;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rate=" + rate +
                ", timeWork='" + timeWork + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return rate == shop.rate && Objects.equals(id, shop.id) && Objects.equals(address, shop.address) && Objects.equals(phone, shop.phone) && Objects.equals(timeWork, shop.timeWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, phone, rate, timeWork);
    }
}
