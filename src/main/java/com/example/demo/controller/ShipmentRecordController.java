package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord create(@RequestBody ShipmentRecord shipment) {
        // createShipment should return ShipmentRecord
        return service.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        // updateShipmentStatus returns void, so return a message
        service.updateShipmentStatus(id, status);
        return "Shipment status updated successfully";
    }

    @GetMapping("/{code}")
    public Optional<ShipmentRecord> getByCode(@PathVariable String code) {
        return service.getShipmentByCode(code);
    }

    @GetMapping
    public List<ShipmentRecord> getAll() {
        return service.getAllShipments();
    }
}
