package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    @Autowired
    private TemperatureSensorLogRepository repository;

    @Override
    public TemperatureSensorLog saveLog(TemperatureSensorLog log) {
        return repository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repository.findAll();
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipmentId(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }
}
