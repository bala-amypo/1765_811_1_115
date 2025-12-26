package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;
import java.util.Optional;

public interface AlertService {
    AlertRecord saveAlert(AlertRecord alertRecord);
    List<AlertRecord> getAllAlerts();
    Optional<AlertRecord> getAlertById(Long id);
    void deleteAlert(Long id);
}
