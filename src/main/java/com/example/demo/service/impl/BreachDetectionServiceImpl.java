package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import java.util.List;

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
    public BreachRecord resolveBreach(Long id) {
        BreachRecord b = repo.findById(id).orElseThrow();
        b.setResolved(true);
        return repo.save(b);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }
}
