// File: src/main/java/com/example/demo/controller/ShipmentRecordController.java
package com.example.demo.controller;

import com.example.demo.service.ShipmentRecordService;

public class ShipmentRecordController {
    private final ShipmentRecordService service;
    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }
}