package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ShipmentRecordEntity;

public interface ShipmentRecordService {

    ShipmentRecordEntity addShipment(ShipmentRecordEntity shipment);

    List<ShipmentRecordEntity> getAllShipments();

    ShipmentRecordEntity getShipmentById(Long id);

    ShipmentRecordEntity getShipmentByCode(String shipmentCode);

    void deleteShipment(Long id);
}
