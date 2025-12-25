package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TemperatureRuleRepositoryStub implements TemperatureRuleRepository {

    private final List<TemperatureRule> rules = new ArrayList<>();

    @Override
    public TemperatureRule save(TemperatureRule rule) {
        rules.add(rule);
        return rule;
    }

    @Override
    public List<TemperatureRule> findAll() {
        return new ArrayList<>(rules);
    }

    @Override
    public List<TemperatureRule> findByActiveTrue() {
        List<TemperatureRule> activeRules = new ArrayList<>();
        for (TemperatureRule r : rules) {
            if (r.isActive()) {
                activeRules.add(r);
            }
        }
        return activeRules;
    }

    @Override
    public TemperatureRule findByProductType(String productType) {
        for (TemperatureRule r : rules) {
            if (r.getProductType() != null && r.getProductType().equals(productType)) {
                return r;
            }
        }
        return null;
    }
}
