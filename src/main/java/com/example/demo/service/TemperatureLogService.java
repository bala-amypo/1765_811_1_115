package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TemperatureLogEntity;

public interface TemperatureLogService {

    TemperatureLogEntity addTemperatureLog(TemperatureLogEntity log);

    List<TemperatureLogEntity> getTemperatureLogs();

    TemperatureLogEntity getTemperatureLogById(Long id);

    void deleteTemperatureLogById(Long id);
}
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TemperatureSensorLogEntity;

public interface TemperatureLogService {

    TemperatureSensorLogEntity addTemperatureLog(TemperatureSensorLogEntity log);

    List<TemperatureSensorLogEntity> getTemperatureLogs();

    TemperatureSensorLogEntity getTemperatureLogById(Long id);

    void deleteTemperatureLogById(Long id);
}
