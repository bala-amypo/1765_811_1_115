package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecordEntity;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository repository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRecordEntity createShipment(ShipmentRecordEntity shipment) {
        return repository.save(shipment);
    }

    public ShipmentRecordEntity updateShipmentStatus(Long id, String status) {
        ShipmentRecordEntity s = repository.findById(id).orElseThrow();
        s.setStatus(status);
        return repository.save(s);
    }

    public ShipmentRecordEntity getShipmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ShipmentRecordEntity getShipmentByCode(String code) {
        return repository.findByShipmentCode(code);
    }

    public List<ShipmentRecordEntity> getAllShipments() {
        return repository.findAll();
    }
}
