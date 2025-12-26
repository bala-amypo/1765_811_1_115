// File: src/main/java/com/example/demo/controller/TemperatureLogController.java
package com.example.demo.controller;

import com.example.demo.service.TemperatureLogService;

public class TemperatureLogController {
    private final TemperatureLogService service;
    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }
}
``