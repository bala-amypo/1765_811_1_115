package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breachId;

    private Long shipmentId;
    private double breachValue;
    private boolean resolved;
    private String severity;
    private Long logId;

    // Getters and Setters
    public Long getBreachId() { return breachId; }
    public void setBreachId(Long breachId) { this.breachId = breachId; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public double getBreachValue() { return breachValue; }
    public void setBreachValue(double breachValue) { this.breachValue = breachValue; }

    public boolean getResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
}
    