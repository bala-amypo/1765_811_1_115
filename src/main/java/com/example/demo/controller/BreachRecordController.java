package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord log(@RequestBody BreachRecord breach) {
        // logBreach should return BreachRecord, if it returns void, just return the input
        service.logBreach(breach);
        return breach;
    }

    @PutMapping("/{id}/resolve")
    public String resolve(@PathVariable Long id) {
        // resolveBreach returns void, so just return a message
        service.resolveBreach(id);
        return "Breach resolved successfully";
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getBreachesByShipment(shipmentId);
    }
}
