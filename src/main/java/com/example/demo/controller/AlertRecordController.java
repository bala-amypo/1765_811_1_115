package com.example.demo.controller;

import com.example.demo.entity.AlertRecordEntity;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public AlertRecordEntity create(@RequestBody AlertRecordEntity alert) {
        return service.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertRecordEntity acknowledge(@PathVariable Long id) {
        return service.acknowledgeAlert(id);
    }

    @GetMapping("/{id}")
    public AlertRecordEntity getById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping
    public List<AlertRecordEntity> getAll() {
        return service.getAllAlerts();
    }
}
