package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    @Autowired
    private ShipmentRecordRepository repository;

    @Override
    public ShipmentRecord addShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }

    @Override
    public ShipmentRecord getShipmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ShipmentRecord getShipmentByCode(String shipmentCode) {
        return repository.findByShipmentCode(shipmentCode);
    }

    @Override
    public void deleteShipment(Long id) {
        repository.deleteById(id);
    }
}
