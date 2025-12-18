package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLogEntity;
import java.util.List;

public interface TemperatureLogService {

    TemperatureSensorLogEntity recordLog(TemperatureSensorLogEntity log);

    List<TemperatureSensorLogEntity> getLogsByShipment(Long shipmentId);

    TemperatureSensorLogEntity getLogById(Long id);

    List<TemperatureSensorLogEntity> getAllLogs();
}
