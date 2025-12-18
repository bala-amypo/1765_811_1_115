package com.example.demo.service;

import com.example.demo.entity.BreachRecordEntity;
import java.util.List;

public interface BreachDetectionService {

    BreachRecordEntity logBreach(BreachRecordEntity breach);

    List<BreachRecordEntity> getBreachesByShipment(Long shipmentId);

    BreachRecordEntity resolveBreach(Long id);

    BreachRecordEntity getBreachById(Long id);

    List<BreachRecordEntity> getAllBreaches();
}
