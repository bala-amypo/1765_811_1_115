package com.example.demo.service;

import com.example.demo.entity.TemperatureRuleEntity;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRuleEntity createRule(TemperatureRuleEntity rule);

    TemperatureRuleEntity updateRule(Long id, TemperatureRuleEntity rule);

    List<TemperatureRuleEntity> getActiveRules();

    List<TemperatureRuleEntity> getRulesByProduct(String productType);

    List<TemperatureRuleEntity> getAllRules();
}
