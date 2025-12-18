package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TemperatureSensorLogEntity;

public interface TemperatureLogService {

    TemperatureSensorLogEntity saveLog(TemperatureSensorLogEntity log);

    List<TemperatureSensorLogEntity> getAllLogs();

    List<TemperatureSensorLogEntity> getLogsByShipmentId(Long shipmentId);
}
