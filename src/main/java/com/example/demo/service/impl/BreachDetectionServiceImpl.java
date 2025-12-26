package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<BreachRecord> opt = breachRepo.findById(id);
        if (opt.isPresent()) {
            BreachRecord breach = opt.get();
            breach.setResolved(true);
            return breachRepo.save(breach);
        }
        throw new RuntimeException("Breach not found");
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepo.findByShipmentId(shipmentId);
    }
}
