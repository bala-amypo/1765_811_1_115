
package com.example.demo.service.impl;

import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import com.example.demo.entity.ShipmentRecord;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {
    private final ShipmentRecordRepository repo;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repo) {
        this.repo = repo;
    }

    public ShipmentRecord createShipment(ShipmentRecord s) { return repo.save(s); }
    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord s = repo.findById(id).orElseThrow();
        s.setStatus(status);
        return repo.save(s);
    }
    public ShipmentRecord getShipmentById(Long id) { return repo.findById(id).orElseThrow(); }
    public List<ShipmentRecord> getAllShipments() { return repo.findAll(); }
}