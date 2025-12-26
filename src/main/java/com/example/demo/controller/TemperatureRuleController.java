package com.example.demo.controller;

import com.example.demo.model.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/rules")
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
    public List<TemperatureRule> activeRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public Optional<TemperatureRule> getRule(
            @PathVariable String productType,
            @RequestParam LocalDate date) {
        return service.getRuleForProduct(productType, date);
    }
}
