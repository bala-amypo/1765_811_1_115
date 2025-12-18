package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BreachRecordEntity;

public interface BreachDetectionService {

    BreachRecordEntity createBreach(BreachRecordEntity breach);

    List<BreachRecordEntity> getAllBreaches();

    BreachRecordEntity getBreachById(Long id);

    void resolveBreach(Long id);   // ✅ ADD THIS
}
