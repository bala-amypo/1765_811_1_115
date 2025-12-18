package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureLogEntity;
import com.example.demo.repository.TemperatureLogRepository;
import com.example.demo.service.TemperatureLogService;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    @Autowired
    TemperatureLogRepository repo;

    @Override
    public TemperatureLogEntity addTemperatureLog(TemperatureLogEntity log) {
        if (log.getRecordedAt() == null) {
            log.setRecordedAt(LocalDateTime.now());
        }
        return repo.save(log);
    }

    @Override
    public List<TemperatureLogEntity> getTemperatureLogs() {
        return repo.findAll();
    }

    @Override
    public TemperatureLogEntity getTemperatureLogById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteTemperatureLogById(Long id) {
        repo.deleteById(id);
    }
}


