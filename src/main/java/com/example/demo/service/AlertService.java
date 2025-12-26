package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;

public interface AlertService {
    List<AlertRecord> getAllAlerts();
    AlertRecord getAlertById(Long id);
    AlertRecord createAlert(AlertRecord alertRecord);
    void deleteAlert(Long id);
}
