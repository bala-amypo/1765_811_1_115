package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/{product}")
    public TemperatureRule getRule(@PathVariable String product) {
        return service.getRuleForProduct(product);
    }
}
