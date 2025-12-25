package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/api/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRule getRule(@PathVariable String productType) {
        return service.getRuleForProduct(productType);
    }

    @GetMapping
    public List<TemperatureRule> getAll() {
        return service.getAllRules();
    }
}
