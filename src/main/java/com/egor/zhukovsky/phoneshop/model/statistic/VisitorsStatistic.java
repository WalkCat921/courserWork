package com.egor.zhukovsky.phoneshop.model.statistic;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class VisitorsStatistic extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private LocalDate date;
    private Long visitorsCount;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getVisitorsCount() {
        return visitorsCount;
    }

    public void setVisitorsCount(Long visitorsCount) {
        this.visitorsCount = visitorsCount;
    }

    @Override
    public String toString() {
        return "VisitorsStatistic{" +
                "id=" + id +
                ", date=" + date +
                ", visitorsCount=" + visitorsCount +
                '}';
    }
}
