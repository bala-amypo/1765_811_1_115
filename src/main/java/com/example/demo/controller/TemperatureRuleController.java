package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    // CREATE RULE
    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    // GET ACTIVE RULES
    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }

    // GET RULE FOR PRODUCT + DATE
    @GetMapping("/product/{productType}")
    public Optional<TemperatureRule> getRuleForProduct(
            @PathVariable String productType,
            @RequestParam(required = false) String date) {

        LocalDate ruleDate =
                (date == null) ? LocalDate.now() : LocalDate.parse(date);

        return service.getRuleForProduct(productType, ruleDate);
    }
}
