package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertRecord;

public interface AlertService {
    AlertRecordEntity addAlert(AlertRecordEntity alert);
    List<AlertRecordEntity> getAllAlerts();
    AlertRecordEntity getAlertById(Long id);
    List<AlertRecordEntity> getAlertsByShipmentId(Long shipmentId);
    void deleteAlertById(Long id);
}
