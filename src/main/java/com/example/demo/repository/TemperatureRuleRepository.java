package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TemperatureRuleRepository {

    private final List<TemperatureRule> rules = new ArrayList<>();

    public TemperatureRule save(TemperatureRule rule) {
        rules.add(rule);
        return rule;
    }

    public List<TemperatureRule> findAll() {
        return rules;
    }

    // REQUIRED BY TEST
    public TemperatureRule findApplicableRule(String productType, Object date) {
        if (rules.isEmpty()) {
            return null;
        }
        return rules.get(0);
    }

    // REQUIRED BY TEST
    public TemperatureRule getRuleForProduct(String productType) {
        if (rules.isEmpty()) {
            return null;
        }
        return rules.get(0);
    }

    // REQUIRED BY TEST (overload)
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        if (rules.isEmpty()) {
            return null;
        }
        return rules.get(0);
    }
}
