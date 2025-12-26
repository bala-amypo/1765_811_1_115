package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Trigger and acknowledge alerts for breaches")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @Operation(summary = "Trigger alert")
    @PostMapping("/")
    public ResponseEntity<AlertRecord> trigger(@RequestBody AlertRecord alert) {
        return ResponseEntity.ok(service.triggerAlert(alert));
    }

    @Operation(summary = "Acknowledge alert by id")
    @PutMapping("/{id}/acknowledge")
    public ResponseEntity<AlertRecord> acknowledge(@PathVariable Long id) {
        return ResponseEntity.of(java.util.Optional.ofNullable(service.acknowledgeAlert(id)));
    }

    @Operation(summary = "Get alerts by shipment")
    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<AlertRecord>> byShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getAlertsByShipment(shipmentId));
    }

    @Operation(summary = "List all alerts")
    @GetMapping("/")
    public ResponseEntity<List<AlertRecord>> all() {
        return ResponseEntity.ok(service.getAllAlerts());
    }
}