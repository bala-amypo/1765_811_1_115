package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import java.util.Optional;

public interface ShipmentRecordService {
    ShipmentRecord saveShipment(ShipmentRecord shipment);
    Optional<ShipmentRecord> getShipmentByCode(String shipmentCode);
}
