package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String productType) {
        return Optional.ofNullable(repository.findByProductType(productType));
    }
}
