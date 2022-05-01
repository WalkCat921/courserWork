package com.egor.zhukovsky.phoneshop.model.product;

import com.egor.zhukovsky.phoneshop.model.entity.Item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class OtherСharacteristics extends Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String audioType;
    private int battery;
    private String material;
    private String graphics;
    private int core;
    private String cpu;
    private String sim;
    private int ram;
    private int builtMemory;

    public OtherСharacteristics() {
    }

    public OtherСharacteristics(String audioType, int battery, String material, String graphics, int core, String cpu, String sim, int ram, int builtMemory) {
        this.audioType = audioType;
        this.battery = battery;
        this.material = material;
        this.graphics = graphics;
        this.core = core;
        this.cpu = cpu;
        this.sim = sim;
        this.ram = ram;
        this.builtMemory = builtMemory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBuiltMemory() {
        return builtMemory;
    }

    public void setBuiltMemory(int builtMemory) {
        this.builtMemory = builtMemory;
    }

    @Override
    public String toString() {
        return "OtherСharacteristics{" +
                "id=" + id +
                ", audioType='" + audioType + '\'' +
                ", battery=" + battery +
                ", material='" + material + '\'' +
                ", graphics='" + graphics + '\'' +
                ", core=" + core +
                ", cpu='" + cpu + '\'' +
                ", sim='" + sim + '\'' +
                ", ram=" + ram +
                ", builtMemory=" + builtMemory +
                "} ";
    }
}
