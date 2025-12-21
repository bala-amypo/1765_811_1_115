package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.exception.BadRequestException;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    // ✅ Constructor Injection (MANDATORY)
    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureRule saveRule(TemperatureRule rule) {

        // ✅ Validation MUST be inside method
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new BadRequestException(
                "Minimum temperature must be less than maximum temperature"
            );
        }

        return repository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getRulesByProductType(String productType) {
        return repository.findByProductType(productType);
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType) {
        return repository.findApplicableRule(productType, LocalDate.now());
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}
