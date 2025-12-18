// package com.example.demo.controller;

// import com.example.demo.entity.ShipmentRecordEntity;
// import com.example.demo.service.ShipmentRecordService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/shipments")
// @Tag(name = "Shipments")
// public class ShipmentRecordController {

//     private final ShipmentRecordService service;

//     public ShipmentRecordController(ShipmentRecordService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ShipmentRecordEntity create(@RequestBody ShipmentRecordEntity shipment) {
//         return service.createShipment(shipment);
//     }

//     @PutMapping("/{id}/status")
//     public ShipmentRecordEntity updateStatus(@PathVariable Long id, @RequestParam String status) {
//         return service.updateShipmentStatus(id, status);
//     }

//     @GetMapping("/{id}")
//     public ShipmentRecordEntity getById(@PathVariable Long id) {
//         return service.getShipmentById(id);
//     }

//     @GetMapping("/code/{code}")
//     public ShipmentRecordEntity getByCode(@PathVariable String code) {
//         return service.getShipmentByCode(code);
//     }

//     @GetMapping
//     public List<ShipmentRecordEntity> getAll() {
//         return service.getAllShipments();
//     }
// }
