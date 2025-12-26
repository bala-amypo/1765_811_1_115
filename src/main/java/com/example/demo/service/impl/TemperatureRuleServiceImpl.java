package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository ruleRepo;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String productType, LocalDate date) {
        return ruleRepo.findApplicableRule(productType, date);
    }
}
