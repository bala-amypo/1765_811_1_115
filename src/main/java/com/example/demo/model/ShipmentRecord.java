package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments", uniqueConstraints = @UniqueConstraint(columnNames = "shipmentCode"))
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private String origin;
    private String destination;
    private String productType;
    private LocalDateTime startDate;
    private LocalDateTime expectedDelivery;
    private String status;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (status == null) status = "IN_TRANSIT";
        createdAt = LocalDateTime.now();
    }

    // getters & setters (ALL)
}
