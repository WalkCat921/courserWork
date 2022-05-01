package com.egor.zhukovsky.phoneshop.model.product;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class CameraСharacteristics extends Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String builtCamera;
    private String video;
    private String frontalCamera;
    private String diaphragm;

    public CameraСharacteristics() {
    }

    public CameraСharacteristics(String builtCamera, String video, String frontalCamera, String diaphragm) {
        this.builtCamera = builtCamera;
        this.video = video;
        this.frontalCamera = frontalCamera;
        this.diaphragm = diaphragm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuiltCamera() {
        return builtCamera;
    }

    public void setBuiltCamera(String builtCamera) {
        this.builtCamera = builtCamera;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getFrontalCamera() {
        return frontalCamera;
    }

    public void setFrontalCamera(String frontalCamera) {
        this.frontalCamera = frontalCamera;
    }

    public String getDiaphragm() {
        return diaphragm;
    }

    public void setDiaphragm(String diaphragm) {
        this.diaphragm = diaphragm;
    }

    @Override
    public String toString() {
        return "CameraСharacteristics{" +
                "id=" + id +
                ", builtCamera='" + builtCamera + '\'' +
                ", video='" + video + '\'' +
                ", frontalCamera='" + frontalCamera + '\'' +
                ", diaphragm='" + diaphragm + '\'' +
                "} ";
    }
}
