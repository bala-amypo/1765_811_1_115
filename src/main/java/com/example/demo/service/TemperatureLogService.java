package com.example.demo.service;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;

public interface TemperatureLogService {
    TemperatureSensorLog recordLog(TemperatureSensorLog log);
    List<TemperatureSensorLog> getLogsByShipment(Long shipmentId);
}