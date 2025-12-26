package com.example.demo.service;

import com.example.demo.entity.BreachRecord;
import java.util.List;

public interface BreachDetectionService {
    BreachRecord recordBreach(BreachRecord breach);
    List<BreachRecord> getBreachesByShipment(Long shipmentId);
}
