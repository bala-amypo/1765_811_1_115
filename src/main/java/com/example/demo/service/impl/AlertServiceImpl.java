// File: src/main/java/com/example/demo/service/impl/AlertServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

import java.util.List;

public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository repo;

    // Constructor injection - exact signature (AlertRecordRepository)
    public AlertServiceImpl(AlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AlertRecord triggerAlert(AlertRecord alert) {
        return repo.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord a = repo.findById(id).orElse(null);
        if (a != null) {
            a.setAcknowledged(true);
            repo.save(a);
        }
        return a;
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}