package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository shipmentRepo;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }

    @Override
    public ShipmentRecord saveShipment(ShipmentRecord shipment) {
        return shipmentRepo.save(shipment);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return shipmentRepo.findByShipmentCode(shipmentCode);
    }
}
