package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

import java.util.List;
import java.util.Optional;

public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository repo;

    public BreachDetectionServiceImpl(BreachRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return repo.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Breach not found"));
        breach.setResolved(true);
        return repo.save(breach);
    }

    @Override
    public Optional<BreachRecord> getBreachById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return repo.findAll();
    }
}
