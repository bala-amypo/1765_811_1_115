package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRuleEntity;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/api/temperature-rules")
public class TemperatureRuleController {

    @Autowired
    private TemperatureRuleService service;

    @PostMapping
    public TemperatureRuleEntity saveRule(
            @RequestBody TemperatureRuleEntity rule) {
        return service.saveRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRuleEntity> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public List<TemperatureRuleEntity> getRulesByProduct(
            @PathVariable String productType) {
        return service.getRulesByProductType(productType);
    }
}
