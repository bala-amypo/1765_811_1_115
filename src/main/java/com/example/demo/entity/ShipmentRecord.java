package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_records")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String shipmentCode;

    private String origin;
    private String destination;
    private String productType;

    private LocalDateTime startDate;
    private LocalDateTime expectedDelivery;

    private String status;

    private LocalDateTime createdAt;

    public ShipmentRecord() {}

    public ShipmentRecord(String shipmentCode, String origin, String destination, String status) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = "IN_TRANSIT";
        }
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProductType() {
        return productType;
    }
    
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    
    public LocalDateTime getExpectedDelivery() {
        return expectedDelivery;
    }
    
    public void setExpectedDelivery(LocalDateTime expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
