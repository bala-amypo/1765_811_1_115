package com.example.demo.service;
import com.example.demo.entity.ShipmentRecord;
import java.util.List;

public interface ShipmentRecordService {
    ShipmentRecord createShipment(ShipmentRecord s);
    ShipmentRecord updateShipmentStatus(Long id, String status);
    ShipmentRecord getShipmentById(Long id);
    List<ShipmentRecord> getAllShipments();
}
