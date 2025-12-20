package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TemperatureSensorLog;

public interface TemperatureLogService {

    TemperatureSensorLog saveLog(TemperatureSensorLog log);

    List<TemperatureSensorLog> getAllLogs();

    List<TemperatureSensorLog> getLogsByShipmentId(Long shipmentId);
}
