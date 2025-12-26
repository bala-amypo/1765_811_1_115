// File: src/main/java/com/example/demo/service/impl/TemperatureLogServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;

import java.util.List;

public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repo;

    // Constructor injection - exact signature (TemperatureSensorLogRepository)
    public TemperatureLogServiceImpl(TemperatureSensorLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return repo.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    @Override
    public TemperatureSensorLog getLogById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repo.findAll();
    }
}