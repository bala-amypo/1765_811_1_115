package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;
import java.util.Optional;

public interface AlertService {
    AlertRecord createAlert(AlertRecord alert);
    Optional<AlertRecord> getAlertById(Long id);
    List<AlertRecord> getAllAlerts();
    void deleteAlert(Long id);
}
