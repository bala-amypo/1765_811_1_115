package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BreachRecord;

public interface BreachDetectionService {

    BreachRecord logBreach(BreachRecord breach);

    List<BreachRecord> getAllBreaches();

    BreachRecord getBreachById(Long id);

    List<BreachRecord> getBreachesByShipmentId(Long shipmentId);
    BreachRecord resolveBreach(Long id);
    void deleteBreachById(Long id);
}
