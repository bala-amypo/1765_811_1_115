package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertRecordController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public AlertRecord addAlert(@RequestBody AlertRecord alert) {
        return alertService.addAlert(alert);
    }

    @GetMapping
    public List<AlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public AlertRecord getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getAlertsByShipmentId(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipmentId(shipmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable Long id) {
        AlertRecord alert = alertService.getAlertById(id);
        if (alert != null) {
            alertService.deleteAlertById(id);
            return "Alert deleted successfully.";
        } else {
            return "Alert not found.";
        }
    }
}
