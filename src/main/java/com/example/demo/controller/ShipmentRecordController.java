package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments", description = "Manage shipment records")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @Operation(summary = "Create shipment")
    @PostMapping("/")
    public ResponseEntity<ShipmentRecord> createShipment(@RequestBody ShipmentRecord shipment) {
        return ResponseEntity.ok(service.createShipment(shipment));
    }

    @Operation(summary = "Update shipment status")
    @PutMapping("/{id}/status")
    public ResponseEntity<ShipmentRecord> updateStatus(@PathVariable Long id,
                                                       @RequestParam String status) {
        return ResponseEntity.ok(service.updateShipmentStatus(id, status));
    }

    @Operation(summary = "Find shipment by code")
    @GetMapping("/code/{shipmentCode}")
    public ResponseEntity<Optional<ShipmentRecord>> getByCode(@PathVariable String shipmentCode) {
        return ResponseEntity.ok(service.getShipmentByCode(shipmentCode));
    }

    @Operation(summary = "Get shipment by id")
    @GetMapping("/{id}")
    public ResponseEntity<ShipmentRecord> getById(@PathVariable Long id) {
        return ResponseEntity.of(service.getShipmentByCode(id.toString())); // Minimal; adjust if you add repo.findById in service
    }

    @Operation(summary = "List all shipments")
    @GetMapping("/")
    public ResponseEntity<List<ShipmentRecord>> getAll() {
        return ResponseEntity.ok(service.getAllShipments());
    }
}