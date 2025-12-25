package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import java.util.List;

public interface TemperatureRuleRepository {
    TemperatureRule save(TemperatureRule rule);
    List<TemperatureRule> findAll();
    List<TemperatureRule> findByActiveTrue();
    TemperatureRule findByProductType(String productType);
}
