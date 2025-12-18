// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.ShipmentRecordEntity;
// import com.example.demo.repository.ShipmentRecordRepository;
// import com.example.demo.service.ShipmentRecordService;

// @Service
// public class ShipmentRecordServiceImpl implements ShipmentRecordService {

//     @Autowired
//     private ShipmentRecordRepository repository;

//     @Override
//     public ShipmentRecordEntity addShipment(ShipmentRecordEntity shipment) {
//         return repository.save(shipment);
//     }

//     @Override
//     public List<ShipmentRecordEntity> getAllShipments() {
//         return repository.findAll();
//     }

//     @Override
//     public ShipmentRecordEntity getShipmentById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public ShipmentRecordEntity getShipmentByCode(String shipmentCode) {
//         return repository.findByShipmentCode(shipmentCode);
//     }

//     @Override
//     public void deleteShipment(Long id) {
//         repository.deleteById(id);
//     }
// }
