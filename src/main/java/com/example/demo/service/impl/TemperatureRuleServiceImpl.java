package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.exception.BadRequestException;


@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    @Autowired
    private TemperatureRuleRepository repository;

    @Override
    public TemperatureRule saveRule(TemperatureRule rule) {
        return repository.save(rule);
    }

if (rule.getMinTemp() >= rule.getMaxTemp()) {
    throw new BadRequestException(
        "Minimum temperature must be less than maximum temperature"
    );
}
    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getRulesByProductType(String productType) {
        return repository.findByProductType(productType);
    }
}
