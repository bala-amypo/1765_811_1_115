// File: src/main/java/com/example/demo/service/TemperatureLogService.java
package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLog;

import java.util.List;

public interface TemperatureLogService {
    TemperatureSensorLog recordLog(TemperatureSensorLog log);
    List<TemperatureSensorLog> getLogsByShipment(Long shipmentId);
    TemperatureSensorLog getLogById(Long id);
    List<TemperatureSensorLog> getAllLogs();
}
``