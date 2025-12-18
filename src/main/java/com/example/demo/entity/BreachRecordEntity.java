package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_records")
public class BreachRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long logId;
    private String breachType;
    private Double breachValue;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public BreachRecordEntity() {}

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
