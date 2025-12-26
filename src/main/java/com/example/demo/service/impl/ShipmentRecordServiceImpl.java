package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository shipmentRepo;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return shipmentRepo.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        Optional<ShipmentRecord> opt = shipmentRepo.findById(id);
        if (opt.isPresent()) {
            ShipmentRecord shipment = opt.get();
            shipment.setStatus(status);
            return shipmentRepo.save(shipment);
        }
        throw new RuntimeException("Shipment not found");
    }

    @Override
    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return shipmentRepo.findByShipmentCode(shipmentCode);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRepo.findAll();
    }
}
