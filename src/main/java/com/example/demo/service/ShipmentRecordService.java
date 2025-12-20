package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ShipmentRecord;

public interface ShipmentRecordService {

    ShipmentRecord addShipment(ShipmentRecord shipment);

    List<ShipmentRecord> getAllShipments();

    ShipmentRecord getShipmentById(Long id);

    ShipmentRecord getShipmentByCode(String shipmentCode);

    void deleteShipment(Long id);
}
