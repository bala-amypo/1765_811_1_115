package com.example.demo.service;

import com.example.demo.entity.AlertRecordEntity;
import java.util.List;

public interface AlertService {

    AlertRecordEntity triggerAlert(AlertRecordEntity alert);

    AlertRecordEntity acknowledgeAlert(Long id);

    List<AlertRecordEntity> getAlertsByShipment(Long shipmentId);

    List<AlertRecordEntity> getAllAlerts();
}
