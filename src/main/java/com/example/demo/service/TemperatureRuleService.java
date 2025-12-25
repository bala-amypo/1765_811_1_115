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

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<TemperatureRule> findApplicableRule(
            String productType,
            LocalDate date
    ) {
        List<TemperatureRule> rules =
                repository.findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        productType,
                        date,
                        date
                );

        return rules.isEmpty()
                ? Optional.empty()
                : Optional.of(rules.get(0));
    }
}
