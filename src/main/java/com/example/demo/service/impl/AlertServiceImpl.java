package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecordEntity;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository repository;

    public AlertServiceImpl(AlertRecordRepository repository) {
        this.repository = repository;
    }

    public AlertRecordEntity triggerAlert(AlertRecordEntity alert) {
        return repository.save(alert);
    }

    public AlertRecordEntity acknowledgeAlert(Long id) {
        AlertRecordEntity alert = repository.findById(id).orElse(null);
        if (alert != null) {
            alert.setAcknowledged(true);
            return repository.save(alert);
        }
        return null;
    }

    public AlertRecordEntity getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<AlertRecordEntity> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<AlertRecordEntity> getAllAlerts() {
        return repository.findAll();
    }
}
