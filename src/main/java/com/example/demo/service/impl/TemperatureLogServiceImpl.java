// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.TemperatureSensorLogEntity;
// import com.example.demo.repository.TemperatureSensorLogRepository;
// import com.example.demo.service.TemperatureLogService;

// @Service
// public class TemperatureLogServiceImpl implements TemperatureLogService {

//     @Autowired
//     private TemperatureSensorLogRepository repository;

//     @Override
//     public TemperatureSensorLogEntity saveLog(TemperatureSensorLogEntity log) {
//         return repository.save(log);
//     }

//     @Override
//     public List<TemperatureSensorLogEntity> getAllLogs() {
//         return repository.findAll();
//     }

//     @Override
//     public List<TemperatureSensorLogEntity> getLogsByShipmentId(Long shipmentId) {
//         return repository.findByShipmentId(shipmentId);
//     }
// }
