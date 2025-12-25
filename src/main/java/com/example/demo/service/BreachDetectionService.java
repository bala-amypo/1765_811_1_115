package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BreachRecord;

public interface BreachDetectionService {

    BreachRecord logBreach(BreachRecord breach);

    BreachRecord resolveBreach(Long id);

    List<BreachRecord> getBreachesByShipment(Long shipmentId);
}
