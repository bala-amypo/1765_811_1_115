// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.BreachRecordEntity;
// import com.example.demo.repository.BreachRecordRepository;
// import com.example.demo.service.BreachDetectionService;

// @Service
// public class BreachDetectionServiceImpl implements BreachDetectionService {

//     @Autowired
//     private BreachRecordRepository repository;

//     @Override
//     public BreachRecordEntity logBreach(BreachRecordEntity breach) {
//         return repository.save(breach);
//     }

//     @Override
//     public List<BreachRecordEntity> getAllBreaches() {
//         return repository.findAll();
//     }

//     @Override
//     public BreachRecordEntity getBreachById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public List<BreachRecordEntity> getBreachesByShipmentId(Long shipmentId) {
//         return repository.findByShipmentId(shipmentId);
//     }

//     @Override
//     public void deleteBreachById(Long id) {
//         repository.deleteById(id);
//     }
// }
