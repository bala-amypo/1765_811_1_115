
package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureSensorLogEntity;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureSensorLogService;

@Service
public class TemperatureSensorLogServiceImpl implements TemperatureSensorLogService {

    @Autowired
    TemperatureSensorLogRepository repo;

    @Override
    public TemperatureSensorLogEntity addTemperatureLog(TemperatureSensorLogEntity log) {
        if (log.getRecordedAt() == null) {
            log.setRecordedAt(LocalDateTime.now());
        }
        return repo.save(log);
    }

    @Override
    public List<TemperatureSensorLogEntity> getTemperatureLogs() {
        return repo.findAll();
    }

    @Override
    public TemperatureSensorLogEntity getTemperatureLogById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteTemperatureLogById(Long id) {
        repo.deleteById(id);
    }
}
