package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertRecordEntity;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRecordRepository repository;

    @Override
    public AlertRecordEntity addAlert(AlertRecordEntity alert) {
        return repository.save(alert);
    }

    @Override
    public List<AlertRecordEntity> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public AlertRecordEntity getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AlertRecordEntity> getAlertsByShipmentId(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public void deleteAlertById(Long id) {
        repository.deleteById(id);
    }
}
