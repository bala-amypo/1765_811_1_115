// File: src/main/java/com/example/demo/controller/TemperatureRuleController.java
package com.example.demo.controller;

import com.example.demo.service.TemperatureRuleService;

public class TemperatureRuleController {
    private final TemperatureRuleService service;
    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }
}