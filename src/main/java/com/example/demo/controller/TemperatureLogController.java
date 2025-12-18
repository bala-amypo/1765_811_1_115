package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TemperatureSensorLogEntity;
import com.example.demo.service.TemperatureSensorLogService;

@RestController
public class TemperatureLogController {

    @Autowired
    TemperatureSensorLogService service;

    @PostMapping("/addTemperatureLog")
    public TemperatureSensorLogEntity addTemperatureLog(
            @RequestBody TemperatureSensorLogEntity log) {
        return service.addTemperatureLog(log);
    }

    @GetMapping("/getTemperatureLogs")
    public List<TemperatureSensorLogEntity> getTemperatureLogs() {
        return service.getTemperatureLogs();
    }

    @GetMapping("/getTemperatureLog/{id}")
    public TemperatureSensorLogEntity getTemperatureLogById(
            @PathVariable Long id) {
        return service.getTemperatureLogById(id);
    }

    @DeleteMapping("/deleteTemperatureLog/{id}")
    public String deleteTemperatureLogById(@PathVariable Long id) {
        TemperatureSensorLogEntity log = service.getTemperatureLogById(id);
        if (log != null) {
            service.deleteTemperatureLogById(id);
            return "Temperature log deleted successfully.";
        } else {
            return "Temperature log not found.";
        }
    }
}