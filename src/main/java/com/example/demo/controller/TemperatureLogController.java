package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs", description = "Record and view temperature sensor logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @Operation(summary = "Record temperature log")
    @PostMapping("/")
    public ResponseEntity<TemperatureSensorLog> record(@RequestBody TemperatureSensorLog log) {
        return ResponseEntity.ok(service.recordLog(log));
    }

    @Operation(summary = "Get logs by shipment")
    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureSensorLog>> byShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getLogsByShipment(shipmentId));
    }

    @Operation(summary = "Get log by id")
    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getById(@PathVariable Long id) {
        return ResponseEntity.of(java.util.Optional.ofNullable(service.getLogById(id)));
    }

    @Operation(summary = "List all logs")
    @GetMapping("/")
    public ResponseEntity<List<TemperatureSensorLog>> getAll() {
        return ResponseEntity.ok(service.getAllLogs());
    }
}