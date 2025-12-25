package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }
        if (rule.getEffectiveTo().isBefore(rule.getEffectiveFrom())) {
            throw new IllegalArgumentException("effectiveTo must be after effectiveFrom");
        }
        return repository.save(rule);
    }

    public Optional<TemperatureRule> getRuleForProduct(String productType, LocalDate date) {
        return repository.findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                productType, date, date);
    }

    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
