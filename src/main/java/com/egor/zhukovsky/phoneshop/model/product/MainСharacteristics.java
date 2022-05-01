package com.egor.zhukovsky.phoneshop.model.product;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MainСharacteristics extends Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private Integer releaseYear;
    private String os;
    private String osVersion;
    private String screenSize;

    public MainСharacteristics() {
    }

    public MainСharacteristics(int releaseYear, String os, String osVersion, String screenSize) {
        this.releaseYear = releaseYear;
        this.os = os;
        this.osVersion = osVersion;
        this.screenSize = screenSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "MainСharacteristics{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", screenSize='" + screenSize + '\'' +
                "} ";
    }
}
