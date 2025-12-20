package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertRecord;

public interface AlertService {
    AlertRecord addAlert(AlertRecord alert);
    List<AlertRecord> getAllAlerts();
    AlertRecord getAlertById(Long id);
    List<AlertRecord> getAlertsByShipmentId(Long shipmentId);
    void deleteAlertById(Long id);
}
