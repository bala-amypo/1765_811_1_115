package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertRecordController {

    private final AlertService alertService;

    @GetMapping
    public List<AlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/{id}")
public ResponseEntity<AlertRecord> getAlert(@PathVariable Long id) {
    AlertRecord alert = alertService.getAlertById(id)
                                    .orElseThrow(() -> new RuntimeException("Alert not found"));
    return ResponseEntity.ok(alert);
}


    @PostMapping
    public AlertRecord createAlert(@RequestBody AlertRecord alertRecord) {
        return alertService.createAlert(alertRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
    }
}
