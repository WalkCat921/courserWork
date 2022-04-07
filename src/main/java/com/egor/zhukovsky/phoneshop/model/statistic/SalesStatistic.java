package com.egor.zhukovsky.phoneshop.model.statistic;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Month;

@Entity
public class SalesStatistic extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long countSales;
    @Column(unique = true)
    private Month month;

    public SalesStatistic() {
    }

    public SalesStatistic(Long countSales, Month month) {
        this.countSales = countSales;
        this.month = month;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountSales() {
        return countSales;
    }

    public void setCountSales(Long countSales) {
        this.countSales = countSales;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
