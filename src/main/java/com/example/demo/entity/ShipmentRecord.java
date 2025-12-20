package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ShipmentRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private String origin;
    private String destination;
    private String productType;

    public ShipmentRecord() {}

    public ShipmentRecord(Long id, String shipmentCode, String origin,
                                String destination, String productType) {
        this.id = id;
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.productType = productType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShipmentCode() { return shipmentCode; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }
}
