package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.ShipmentRecord;

public interface ShipmentRecordService {

    ShipmentRecord createShipment(ShipmentRecord shipment);

    ShipmentRecord updateShipmentStatus(Long id, String newStatus);

    Optional<ShipmentRecord> getShipmentByCode(String shipmentCode);

    List<ShipmentRecord> getAllShipments();
}
