package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.time.LocalDate;
import java.util.Optional;

public interface TemperatureRuleService {
    Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date);
}
