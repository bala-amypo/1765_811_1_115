// File: src/main/java/com/example/demo/controller/BreachRecordController.java
package com.example.demo.controller;

import com.example.demo.service.BreachDetectionService;

public class BreachRecordController {
    private final BreachDetectionService service;
    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }
}