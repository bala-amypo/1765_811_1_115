package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.util.List;

public interface TemperatureRuleService {
    TemperatureRule save(TemperatureRule rule);
    List<TemperatureRule> getAllRules();
    TemperatureRule getRuleForProduct(String productType);
}
