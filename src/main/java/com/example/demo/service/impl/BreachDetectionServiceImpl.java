package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class BreachDetectionServiceImpl
        implements BreachDetectionService {

    private final BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return repository.save(breach);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return repository.findAll();
    }

    @Override
    public BreachRecord getBreachById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Breach not found with id: " + id));
    }

    @Override
    public List<BreachRecord> getBreachesByShipmentId(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    // ✅ THIS REMOVES THE OVERRIDE ERROR
    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = getBreachById(id);
        breach.setResolved(true);
        return repository.save(breach);
    }
    @Override
public void deleteBreachById(Long id) {
    repository.deleteById(id);
}

}
