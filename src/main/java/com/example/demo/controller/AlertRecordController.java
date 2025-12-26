package com.example.demo.controller;

import com.example.demo.model.AlertRecord;
import com.example.demo.service.AlertService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/alerts")
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
    public List<AlertRecord> getAlerts(@PathVariable Long shipmentId) {
        return service.getAlertsByShipment(shipmentId);
    }
}
