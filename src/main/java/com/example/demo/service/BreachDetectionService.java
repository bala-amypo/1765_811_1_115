package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BreachRecordEntity;

public interface BreachDetectionService {

    BreachRecordEntity logBreach(BreachRecordEntity breach);

    List<BreachRecordEntity> getAllBreaches();

    BreachRecordEntity getBreachById(Long id);

    List<BreachRecordEntity> getBreachesByShipmentId(Long shipmentId);

    void deleteBreachById(Long id);
}
