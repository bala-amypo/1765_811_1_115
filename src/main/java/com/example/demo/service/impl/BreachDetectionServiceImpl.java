// File: src/main/java/com/example/demo/service/impl/BreachDetectionServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

import java.util.List;
@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository repo;

    // Constructor injection - exact signature (BreachRecordRepository)
    public BreachDetectionServiceImpl(BreachRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return repo.save(breach);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord b = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
        b.setResolved(true);
        return repo.save(b);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    @Override
    public BreachRecord getBreachById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return repo.findAll();
    }
}