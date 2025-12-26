package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleService {
    List<TemperatureRule> getActiveRules();
    Optional<TemperatureRule> getApplicableRule(String productType, LocalDate date);
}
    