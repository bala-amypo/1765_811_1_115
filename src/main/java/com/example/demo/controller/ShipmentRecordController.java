// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.ShipmentRecordEntity;
// import com.example.demo.service.ShipmentRecordService;

// @RestController
// @RequestMapping("/api/shipments")
// public class ShipmentRecordController {

//     @Autowired
//     private ShipmentRecordService service;

//     @PostMapping
//     public ShipmentRecordEntity addShipment(@RequestBody ShipmentRecordEntity shipment) {
//         return service.addShipment(shipment);
//     }

//     @GetMapping
//     public List<ShipmentRecordEntity> getAllShipments() {
//         return service.getAllShipments();
//     }

//     @GetMapping("/{id}")
//     public ShipmentRecordEntity getShipmentById(@PathVariable Long id) {
//         return service.getShipmentById(id);
//     }

//     @GetMapping("/code/{code}")
//     public ShipmentRecordEntity getShipmentByCode(@PathVariable String code) {
//         return service.getShipmentByCode(code);
//     }

//     @DeleteMapping("/{id}")
//     public String deleteShipment(@PathVariable Long id) {
//         service.deleteShipment(id);
//         return "Shipment deleted successfully";
//     }
// }
