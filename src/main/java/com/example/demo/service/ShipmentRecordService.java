package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import java.util.List;
import java.util.Optional;

public interface ShipmentRecordService {
    ShipmentRecord createShipment(ShipmentRecord shipment);
    void updateShipmentStatus(Long shipmentId, String status);
    Optional<ShipmentRecord> getShipmentByCode(String shipmentCode);
    List<ShipmentRecord> getAllShipments();
}
