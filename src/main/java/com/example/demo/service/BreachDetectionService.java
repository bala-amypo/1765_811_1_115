package com.example.demo.service;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;

public interface BreachDetectionService {
    BreachRecord logBreach(BreachRecord breach);
    BreachRecord resolveBreach(Long id);
    List<BreachRecord> getBreachesByShipment(Long shipmentId);
}