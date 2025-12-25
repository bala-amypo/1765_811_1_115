package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository repository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    public ShipmentRecord updateShipmentStatus(Long id, String newStatus) {
        ShipmentRecord shipment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        shipment.setStatus(newStatus);
        return repository.save(shipment);
    }

    public Optional<ShipmentRecord> getShipmentByCode(String shipmentCode) {
        return repository.findByShipmentCode(shipmentCode);
    }

    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }
}
