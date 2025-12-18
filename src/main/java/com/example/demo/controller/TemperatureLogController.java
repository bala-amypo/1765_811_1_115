package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLogEntity;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureSensorLogEntity create(@RequestBody TemperatureSensorLogEntity log) {
        return service.recordLog(log);
    }

    @GetMapping("/{id}")
    public TemperatureSensorLogEntity getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLogEntity> getByShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    @GetMapping
    public List<TemperatureSensorLogEntity> getAll() {
        return service.getAllLogs();
    }
}
