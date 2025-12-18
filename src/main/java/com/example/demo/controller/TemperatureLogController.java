// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.TemperatureSensorLogEntity;
// import com.example.demo.service.TemperatureLogService;

// @RestController
// @RequestMapping("/api/temperature-logs")
// public class TemperatureLogController {

//     @Autowired
//     private TemperatureLogService service;

//     @PostMapping
//     public TemperatureSensorLogEntity saveLog(
//             @RequestBody TemperatureSensorLogEntity log) {
//         return service.saveLog(log);
//     }

//     @GetMapping
//     public List<TemperatureSensorLogEntity> getAllLogs() {
//         return service.getAllLogs();
//     }

//     @GetMapping("/shipment/{shipmentId}")
//     public List<TemperatureSensorLogEntity> getLogsByShipment(
//             @PathVariable Long shipmentId) {
//         return service.getLogsByShipmentId(shipmentId);
//     }
// }
