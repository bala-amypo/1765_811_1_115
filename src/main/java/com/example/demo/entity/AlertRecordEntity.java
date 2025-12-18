package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private String alertType;
    private String message;
    private LocalDateTime sentAt;
    private Boolean acknowledged;

    public AlertRecordEntity() {}

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
        this.acknowledged = false;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Boolean getAcknowledged() { return acknowledged; }
    public void setAcknowledged(Boolean acknowledged) { this.acknowledged = acknowledged; }
}
