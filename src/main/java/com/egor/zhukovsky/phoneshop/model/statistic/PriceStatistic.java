package com.egor.zhukovsky.phoneshop.model.statistic;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Month;
import java.util.Objects;

@Entity
public class PriceStatistic extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPrice;
    @Column(unique = true)
    private Month month;

    public PriceStatistic() {

    }

    public PriceStatistic(BigDecimal totalPrice, Month month) {
        this.totalPrice = totalPrice;
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceStatistic that = (PriceStatistic) o;
        return Objects.equals(id, that.id) && Objects.equals(totalPrice, that.totalPrice) && month == that.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, month);
    }

    @Override
    public String toString() {
        return "PriceStatistic{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", month=" + month +
                '}';
    }
}
