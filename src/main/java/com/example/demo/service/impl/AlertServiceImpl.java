package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

import java.util.List;
import java.util.Optional;

public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository repo;

    public AlertServiceImpl(AlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AlertRecord triggerAlert(AlertRecord alert) {
        return repo.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setAcknowledged(true);
        return repo.save(alert);
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    @Override
    public Optional<AlertRecord> getAlertById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
