package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;

@RestController
@RequestMapping("/api/temperature-logs")
public class TemperatureLogController {

    @Autowired
    private TemperatureLogService service;

    @PostMapping
    public TemperatureSensorLog saveLog(
            @RequestBody TemperatureSensorLog log) {
        return service.saveLog(log);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAllLogs() {
        return service.getAllLogs();
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipment(
            @PathVariable Long shipmentId) {
        return service.getLogsByShipmentId(shipmentId);
    }
}
