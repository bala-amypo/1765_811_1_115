package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    List<TemperatureRule> getAllRules();

    Optional<TemperatureRule> getRuleForProduct(String productType);
}
