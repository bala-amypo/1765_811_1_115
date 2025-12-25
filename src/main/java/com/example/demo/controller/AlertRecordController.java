package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public AlertRecord trigger(@RequestBody AlertRecord alert) {
        return service.triggerAlert(alert);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getAlertsByShipment(shipmentId);
    }
}
