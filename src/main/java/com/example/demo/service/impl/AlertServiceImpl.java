package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository alertRecordRepository;

   @Override
public AlertRecord createAlert(AlertRecord alert) {
    return alertRepository.save(alert);
}


    @Override
    public List<AlertRecord> getAllAlerts() {
        return alertRecordRepository.findAll();
    }

    @Override
    public Optional<AlertRecord> getAlertById(Long id) {
        return alertRecordRepository.findById(id);
    }

    @Override
    public void deleteAlert(Long id) {
        alertRecordRepository.deleteById(id);
    }
}
