package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentId;
    private String productType;
    private double recordedTemperature;

    private double minAllowedTemp;
    private double maxAllowedTemp;

    private LocalDateTime breachTime;

    @Column(nullable = false)
    private boolean resolved = false;

    // 🔹 Constructors
    public BreachRecord() {}

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getRecordedTemperature() {
        return recordedTemperature;
    }

    public void setRecordedTemperature(double recordedTemperature) {
        this.recordedTemperature = recordedTemperature;
    }

    public double getMinAllowedTemp() {
        return minAllowedTemp;
    }

    public void setMinAllowedTemp(double minAllowedTemp) {
        this.minAllowedTemp = minAllowedTemp;
    }

    public double getMaxAllowedTemp() {
        return maxAllowedTemp;
    }

    public void setMaxAllowedTemp(double maxAllowedTemp) {
        this.maxAllowedTemp = maxAllowedTemp;
    }

    public LocalDateTime getBreachTime() {
        return breachTime;
    }

    public void setBreachTime(LocalDateTime breachTime) {
        this.breachTime = breachTime;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
