// File: src/main/java/com/example/demo/service/impl/TemperatureRuleServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repo;

    // Constructor injection - exact signature (TemperatureRuleRepository)
    public TemperatureRuleServiceImpl(TemperatureRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() == null || rule.getMaxTemp() == null ||
            rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }
        if (rule.getEffectiveFrom() != null && rule.getEffectiveTo() != null &&
            !rule.getEffectiveTo().isAfter(rule.getEffectiveFrom())) {
            throw new IllegalArgumentException("effectiveTo must be after effectiveFrom");
        }
        return repo.save(rule);
    }

    @Override
    public TemperatureRule updateRule(Long id, TemperatureRule rule) {
        rule.setId(id);
        return createRule(rule); // reuse validation, then save
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String productType, LocalDate date) {
        return repo.findApplicableRule(productType, date);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repo.findAll();
    }
}