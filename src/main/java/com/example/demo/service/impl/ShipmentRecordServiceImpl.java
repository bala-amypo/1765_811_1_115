// File: src/main/java/com/example/demo/service/impl/ShipmentRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository repo;

    // Constructor injection - exact signature (ShipmentRecordRepository)
    public ShipmentRecordServiceImpl(ShipmentRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repo.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(Long id, String newStatus) {
        ShipmentRecord s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        s.setStatus(newStatus);
        return repo.save(s);
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