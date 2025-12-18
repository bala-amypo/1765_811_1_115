package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecordEntity;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertRecordController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public AlertRecordEntity addAlert(@RequestBody AlertRecordEntity alert) {
        return alertService.addAlert(alert);
    }

    @GetMapping
    public List<AlertRecordEntity> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public AlertRecordEntity getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecordEntity> getAlertsByShipmentId(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipmentId(shipmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable Long id) {
        AlertRecordEntity alert = alertService.getAlertById(id);
        if (alert != null) {
            alertService.deleteAlertById(id);
            return "Alert deleted successfully.";
        } else {
            return "Alert not found.";
        }
    }
}
