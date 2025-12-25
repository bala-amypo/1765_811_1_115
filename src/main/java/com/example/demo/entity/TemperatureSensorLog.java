package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private String sensorId;

    private Double temperatureValue;

    private LocalDateTime recordedAt;

    private String location;

    public TemperatureSensorLog() {}

    public TemperatureSensorLog(Long shipmentId, Double temperatureValue,
                                LocalDateTime recordedAt, String location) {
        this.shipmentId = shipmentId;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.location = location;
    }

    @PrePersist
    public void prePersist() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }
    
    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }
    
    public String getSensorId() {
        return sensorId;
    }
    
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
    
    public Double getTemperatureValue() {
        return temperatureValue;
    }
    
    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }
    
    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
    
    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}
