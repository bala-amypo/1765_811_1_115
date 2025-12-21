package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    @Autowired
    private BreachRecordRepository repository;

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return repository.save(breach);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return repository.findAll();
    }

    // @Override
    // public BreachRecord getBreachById(Long id) {
    //     return repository.findById(id).orElse(null);
    // }

@Override
public BreachRecordOnly getBreachById(Long id) {
    return repository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Breach not found with id: " + id));
}



    @Override
    public List<BreachRecord> getBreachesByShipmentId(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public void deleteBreachById(Long id) {
        repository.deleteById(id);
    }
}
