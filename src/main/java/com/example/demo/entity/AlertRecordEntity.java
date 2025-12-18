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

    public AlertRecordEntity(Long shipmentId, Long breachId,
                             String alertType, String message) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.alertType = alertType;
        this.message = message;
    }

    @PrePersist
    public void onSend() {
        sentAt = LocalDateTime.now();
        if (acknowledged == null) acknowledged = false;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Boolean getAcknowledged() { return acknowledged; }
    public void setAcknowledged(Boolean acknowledged) { this.acknowledged = acknowledged; }
}
