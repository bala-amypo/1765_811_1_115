// File: src/main/java/com/example/demo/controller/AlertRecordController.java
package com.example.demo.controller;

import com.example.demo.service.AlertService;

public class AlertRecordController {
    private final AlertService service;
    public AlertRecordController(AlertService service) {
        this.service = service;
    }
}