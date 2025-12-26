package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service  // ✅ important annotation
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository alertRecordRepository;

    public AlertServiceImpl(AlertRecordRepository alertRecordRepository) {
        this.alertRecordRepository = alertRecordRepository;
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        return alertRecordRepository.findAll();
    }

    @Override
    public AlertRecord getAlertById(Long id) {
        return alertRecordRepository.findById(id).orElse(null);
    }

    @Override
    public AlertRecord createAlert(AlertRecord alertRecord) {
        return alertRecordRepository.save(alertRecord);
    }

    @Override
    public void deleteAlert(Long id) {
        alertRecordRepository.deleteById(id);
    }
}
