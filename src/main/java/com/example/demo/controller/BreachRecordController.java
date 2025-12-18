package com.example.demo.controller;

import com.example.demo.entity.BreachRecordEntity;
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
    public BreachRecordEntity create(@RequestBody BreachRecordEntity breach) {
        return service.logBreach(breach);
    }

    // @PutMapping("/{id}/resolve")
    // public BreachRecordEntity resolve(@PathVariable Long id) {
    //     return service.resolveBreach(id);
    // }

    @GetMapping("/{id}")
    public BreachRecordEntity getById(@PathVariable Long id) {
        return service.getBreachById(id);
    }

    @GetMapping
    public List<BreachRecordEntity> getAll() {
        return service.getAllBreaches();
    }
}
