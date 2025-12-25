package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleService {

    Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date);

    // Add the missing methods
    TemperatureRule createRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    Optional<TemperatureRule> getRuleForProduct(String productType, LocalDate date);
}
