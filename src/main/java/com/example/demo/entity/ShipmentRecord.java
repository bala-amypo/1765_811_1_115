package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shipment_records")
public class ShipmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String shipmentCode;

    private String origin;
    private String destination;
    private String status;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "shipmentId", cascade = CascadeType.ALL)
    private List<TemperatureSensorLog> logs;

    @PrePersist
    public void prePersist() {
        if (status == null) status = "IN_TRANSIT";
        createdAt = LocalDateTime.now();
    }

    public ShipmentRecord() {}

    public ShipmentRecord(String shipmentCode, String origin, String destination, String status) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShipmentCode() { return shipmentCode; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<TemperatureSensorLog> getLogs() { return logs; }
    public void setLogs(List<TemperatureSensorLog> logs) { this.logs = logs; }
}
