package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breaches", description = "Log and resolve temperature breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @Operation(summary = "Log breach (manual)")
    @PostMapping("/")
    public ResponseEntity<BreachRecord> log(@RequestBody BreachRecord breach) {
        return ResponseEntity.ok(service.logBreach(breach));
    }

    @Operation(summary = "Resolve breach by id")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<BreachRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.resolveBreach(id));
    }

    @Operation(summary = "Get breaches by shipment")
    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<BreachRecord>> byShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getBreachesByShipment(shipmentId));
    }

    @Operation(summary = "Get breach by id")
    @GetMapping("/{id}")
    public ResponseEntity<BreachRecord> byId(@PathVariable Long id) {
        return ResponseEntity.of(java.util.Optional.ofNullable(service.getBreachById(id)));
    }

    @Operation(summary = "List all breaches")
    @GetMapping("/")
    public ResponseEntity<List<BreachRecord>> all() {
        return ResponseEntity.ok(service.getAllBreaches());
    }
}