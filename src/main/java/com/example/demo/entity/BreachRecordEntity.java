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

    public BreachRecordEntity(Long shipmentId, Long logId, String breachType,
                              Double breachValue, String severity, String details) {
        this.shipmentId = shipmentId;
        this.logId = logId;
        this.breachType = breachType;
        this.breachValue = breachValue;
        this.severity = severity;
        this.details = details;
    }

    @PrePersist
    public void onDetect() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
