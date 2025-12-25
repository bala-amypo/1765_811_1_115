package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleService {
    TemperatureRule createRule(TemperatureRule rule);
    List<TemperatureRule> getActiveRules();
    TemperatureRule getRuleForProduct(String productType);
    List<TemperatureRule> getAllRules();
}
