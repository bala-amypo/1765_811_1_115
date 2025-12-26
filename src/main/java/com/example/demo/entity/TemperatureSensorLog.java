package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
public class TemperatureSensorLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;

    private String sensorId;

    private LocalDateTime recordedAt;

    private Double temperatureValue;

    @Column(nullable = true)
    private String location; // optional

    public TemperatureSensorLog() {}

    public TemperatureSensorLog(Long shipmentId, Double temperatureValue, LocalDateTime recordedAt, String location) {
        this.shipmentId = shipmentId;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.location = location;
    }

    @PrePersist
    public void prePersist() {
        if (recordedAt == null) recordedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }

    public Double getTemperatureValue() { return temperatureValue; }
    public void setTemperatureValue(Double temperatureValue) { this.temperatureValue = temperatureValue; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}