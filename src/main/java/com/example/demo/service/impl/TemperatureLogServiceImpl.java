package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;

import java.util.List;
import java.util.Optional;

public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repo;

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
    public Optional<TemperatureSensorLog> getLogById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repo.findAll();
    }
}
