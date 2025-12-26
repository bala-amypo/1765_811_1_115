package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;

import java.util.List;
import java.util.Optional;

public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository repo;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repo.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord shipment = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
        shipment.setStatus(status);
        return repo.save(shipment);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return repo.findByShipmentCode(shipmentCode);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return repo.findAll();
    }
}
