package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord create(@RequestBody BreachRecord breach) {
        return service.logBreach(breach);
    }

    @GetMapping("/{id}")
    public BreachRecord getById(@PathVariable Long id) {
        return service.getBreachById(id);
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return service.getAllBreaches();
    }
}
