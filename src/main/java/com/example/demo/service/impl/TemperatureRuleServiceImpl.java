package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    @Autowired
    private TemperatureRuleRepository temperatureRuleRepository;

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return temperatureRuleRepository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return temperatureRuleRepository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return temperatureRuleRepository.findAll();
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String productType) {
        // Ensure we return Optional, not TemperatureRule directly
        return temperatureRuleRepository.findByProductType(productType);
    }
}
