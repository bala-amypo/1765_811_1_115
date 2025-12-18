// package com.example.demo.service.impl;

// import com.example.demo.entity.TemperatureSensorLogEntity;
// import com.example.demo.repository.TemperatureSensorLogRepository;
// import com.example.demo.service.TemperatureLogService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TemperatureLogServiceImpl implements TemperatureLogService {

//     private final TemperatureSensorLogRepository repository;

//     public TemperatureLogServiceImpl(TemperatureSensorLogRepository repository) {
//         this.repository = repository;
//     }

//     public TemperatureSensorLogEntity recordLog(TemperatureSensorLogEntity log) {
//         return repository.save(log);
//     }

//     public TemperatureSensorLogEntity getLogById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     public List<TemperatureSensorLogEntity> getLogsByShipment(Long shipmentId) {
//         return repository.findByShipmentId(shipmentId);
//     }

//     public List<TemperatureSensorLogEntity> getAllLogs() {
//         return repository.findAll();
//     }
// }
