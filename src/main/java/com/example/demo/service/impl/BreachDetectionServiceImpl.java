package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

import java.util.List;
@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRepo;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRepo) {
        this.breachRepo = breachRepo;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return breachRepo.save(breach);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
        breach.setResolved(true);
        return breachRepo.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepo.findByShipmentId(shipmentId);
    }
}
