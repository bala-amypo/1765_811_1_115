package com.example.demo.service;

import com.example.demo.entity.*;
import java.time.LocalDate;
import java.util.*;

public interface AlertService {
    AlertRecord triggerAlert(AlertRecord alert);
    List<AlertRecord> getAlertsByShipment(Long shipmentId);
}