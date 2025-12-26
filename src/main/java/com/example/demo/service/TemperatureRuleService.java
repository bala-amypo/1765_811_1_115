package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleService {

    // Get all temperature rules
    List<TemperatureRule> getAllRules();

    // Get all active rules
    List<TemperatureRule> getActiveRules();

    // Get applicable rule for a product on a given date
    Optional<TemperatureRule> getApplicableRule(String productType, LocalDate date);

    // Save a new temperature rule
    TemperatureRule saveRule(TemperatureRule rule);

    // Find rule by ID
    Optional<TemperatureRule> getRuleById(Long id);

    // Delete a rule by ID
    void deleteRule(Long id);
}
