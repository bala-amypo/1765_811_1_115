package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repo;

    @Autowired
    public TemperatureRuleServiceImpl(TemperatureRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repo.findAll();
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<TemperatureRule> getApplicableRule(String productType, LocalDate date) {
        return repo.findApplicableRule(productType, date);
    }

    @Override
    public TemperatureRule saveRule(TemperatureRule rule) {
        return repo.save(rule);
    }

    @Override
    public Optional<TemperatureRule> getRuleById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteRule(Long id) {
        repo.deleteById(id);
    }
}
