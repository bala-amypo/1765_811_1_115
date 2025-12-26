package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;
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
    public void resolveBreach(Long breachId) {
        breachRepo.findById(breachId).ifPresent(b -> {
            b.setResolved(true);
            breachRepo.save(b);
        });
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepo.findByShipmentId(shipmentId);
    }
}
