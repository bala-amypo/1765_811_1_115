package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/api/temperature-rules")
public class TemperatureRuleController {

    @Autowired
    private TemperatureRuleService temperatureRuleService;

    @GetMapping("/active")
    public ResponseEntity<List<TemperatureRule>> getActiveRules() {
        List<TemperatureRule> rules = temperatureRuleService.getActiveRules();
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/{productType}")
    public ResponseEntity<TemperatureRule> getRuleForProduct(@PathVariable String productType) {
        Optional<TemperatureRule> ruleOpt = temperatureRuleService.getRuleForProduct(productType);
        return ruleOpt.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
