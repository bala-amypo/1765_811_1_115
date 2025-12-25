package com.example.demo.service;

import com.example.demo.entity.*;
import java.time.LocalDate;
import java.util.*;

public interface ShipmentRecordService {
    ShipmentRecord createShipment(ShipmentRecord shipment);
    ShipmentRecord updateShipmentStatus(Long id, String newStatus);
    Optional<ShipmentRecord> getShipmentByCode(String shipmentCode);
    List<ShipmentRecord> getAllShipments();
}