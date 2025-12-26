package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules", description = "Manage temperature rules for products")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @Operation(summary = "Create temperature rule")
    @PostMapping("/")
    public ResponseEntity<TemperatureRule> create(@RequestBody TemperatureRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @Operation(summary = "Update temperature rule")
    @PutMapping("/{id}")
    public ResponseEntity<TemperatureRule> update(@PathVariable Long id,
                                                  @RequestBody TemperatureRule rule) {
        return ResponseEntity.ok(service.updateRule(id, rule));
    }

    @Operation(summary = "Get active rules")
    @GetMapping("/active")
    public ResponseEntity<List<TemperatureRule>> active() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @Operation(summary = "Get applicable rule for product")
    @GetMapping("/product/{productType}")
    public ResponseEntity<Optional<TemperatureRule>> ruleForProduct(@PathVariable String productType,
                                                                    @RequestParam(required = false) LocalDate date) {
        LocalDate d = (date != null ? date : LocalDate.now());
        return ResponseEntity.ok(service.getRuleForProduct(productType, d));
    }

    @Operation(summary = "List all rules")
    @GetMapping("/")
    public ResponseEntity<List<TemperatureRule>> allRules() {
        return ResponseEntity.ok(service.getAllRules());
    }
}