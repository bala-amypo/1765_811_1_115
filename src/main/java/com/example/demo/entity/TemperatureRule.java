package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TemperatureRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private double minTemp;
    private double maxTemp;
    private boolean active;

    public TemperatureRuleEntity() {}

    public TemperatureRuleEntity(Long id, String productType,
                                 double minTemp, double maxTemp, boolean active) {
        this.id = id;
        this.productType = productType;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public double getMinTemp() { return minTemp; }
    public void setMinTemp(double minTemp) { this.minTemp = minTemp; }

    public double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(double maxTemp) { this.maxTemp = maxTemp; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
