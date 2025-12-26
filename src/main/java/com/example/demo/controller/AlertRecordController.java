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
    public AlertRecord getAlert(@PathVariable Long id) {
        return alertService.getAlertById(id);
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
