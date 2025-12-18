package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TemperatureLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private String sensorId;
    private LocalDateTime recordedAt;
    private Double temperatureValue;
    private String location; // optional

    public TemperatureLogEntity() {
        this.recordedAt = LocalDateTime.now(); // default now
    }

    public TemperatureLogEntity(Long id, Long shipmentId, String sensorId,
import com.example.demo.entity.TemperatureLogEntity;

@Repository
public interface TemperatureLogRepository
        extends JpaRepository<TemperatureLogEntity, Long> {

}
