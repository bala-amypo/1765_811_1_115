// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "temperature_rules")
// public class TemperatureRuleEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String productType;
//     private Double minTemp;
//     private Double maxTemp;
//     private Boolean active;
//     private LocalDate effectiveFrom;
//     private LocalDate effectiveTo;

//     public TemperatureRuleEntity() {}

//     // Getters & Setters
//     public Long getId() { return id; }
//     public String getProductType() { return productType; }
//     public void setProductType(String productType) { this.productType = productType; }

//     public Double getMinTemp() { return minTemp; }
//     public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

//     public Double getMaxTemp() { return maxTemp; }
//     public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }

//     public Boolean getActive() { return active; }
//     public void setActive(Boolean active) { this.active = active; }

//     public LocalDate getEffectiveFrom() { return effectiveFrom; }
//     public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }

//     public LocalDate getEffectiveTo() { return effectiveTo; }
//     public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
// }
