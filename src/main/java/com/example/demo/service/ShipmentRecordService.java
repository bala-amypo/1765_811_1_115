package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TemperatureSensorLogEntity;

public interface TemperatureSensorLogService {

    TemperatureSensorLogEntity addTemperatureLog(TemperatureSensorLogEntity log);

    List<TemperatureSensorLogEntity> getTemperatureLogs();

    TemperatureSensorLogEntity getTemperatureLogById(Long id);

    void deleteTemperatureLogById(Long id);
}

