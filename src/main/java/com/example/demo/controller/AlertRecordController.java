package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public AlertRecord create(@RequestBody AlertRecord alert) {
        return service.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertRecord acknowledge(@PathVariable Long id) {
        return service.acknowledgeAlert(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getAlertsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public Optional<AlertRecord> getById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping
    public List<AlertRecord> getAll() {
        return service.getAllAlerts();
    }
}
