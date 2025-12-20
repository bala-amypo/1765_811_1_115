package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/api/temperature-rules")
public class TemperatureRuleController {

    @Autowired
    private TemperatureRuleService service;

    @PostMapping
    public TemperatureRule saveRule(
            @RequestBody TemperatureRule rule) {
        return service.saveRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public List<TemperatureRule> getRulesByProduct(
            @PathVariable String productType) {
        return service.getRulesByProductType(productType);
    }
}
