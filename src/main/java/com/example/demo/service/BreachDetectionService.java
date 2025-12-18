package com.example.demo.service;

import com.example.demo.entity.BreachRecordEntity;
import java.util.List;

public interface BreachDetectionService {

    BreachRecordEntity logBreach(BreachRecordEntity breach);

    BreachRecordEntity resolveBreach(Long id);

    BreachRecordEntity getBreachById(Long id);

    List<BreachRecordEntity> getBreachesByShipment(Long shipmentId);

    List<BreachRecordEntity> getAllBreaches();
}
