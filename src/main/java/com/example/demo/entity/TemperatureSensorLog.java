package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TemperatureSensorLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private double temperature;
    private LocalDateTime loggedAt;

    public TemperatureSensorLogEntity() {}

    public TemperatureSensorLogEntity(Long id, Long shipmentId,
                                      double temperature, LocalDateTime loggedAt) {
        this.id = id;
        this.shipmentId = shipmentId;
        this.temperature = temperature;
        this.loggedAt = loggedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
}
