package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecordEntity;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    @Autowired
    private BreachRecordRepository repository;

    @Override
    public void resolveBreach(Long id) {
        BreachRecordEntity breach = repository.findById(id).orElse(null);
        if (breach != null) {
            breach.setResolved(true);
            repository.save(breach);
        }
    }
}
