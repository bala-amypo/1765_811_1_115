package com.example.demo.entity;

import java.time.LocalDate;

public class TemperatureRule {

    private String productType;
    private boolean active;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }

    public LocalDate getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
}
