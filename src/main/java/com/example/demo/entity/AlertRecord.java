package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private Boolean acknowledged;
    private LocalDateTime sentAt;

    public AlertRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.acknowledged == null) {
            this.acknowledged = false;
        }
        if (this.sentAt == null) {
            this.sentAt = LocalDateTime.now();
        }
    }

    // getters & setters
    public Long getId() { return id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Long getBreachId() { return breachId; }
    public void setBreachId(Long breachId) { this.breachId = breachId; }

    public Boolean getAcknowledged() { return acknowledged; }
    public void setAcknowledged(Boolean acknowledged) { this.acknowledged = acknowledged; }

    public LocalDateTime getSentAt() { return sentAt; }
}
