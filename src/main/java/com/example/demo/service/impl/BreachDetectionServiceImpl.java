// package com.example.demo.service.impl;

// import com.example.demo.entity.BreachRecordEntity;
// import com.example.demo.repository.BreachRecordRepository;
// import com.example.demo.service.BreachDetectionService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class BreachDetectionServiceImpl implements BreachDetectionService {

//     private final BreachRecordRepository repository;

//     public BreachDetectionServiceImpl(BreachRecordRepository repository) {
//         this.repository = repository;
//     }

//     public BreachRecordEntity logBreach(BreachRecordEntity breach) {
//         return repository.save(breach);
//     }

//     public BreachRecordEntity resolveBreach(Long id) {
//         BreachRecordEntity breach = repository.findById(id).orElse(null);
//         if (breach != null) {
//             breach.setResolved(true);
//             return repository.save(breach);
//         }
//         return null;
//     }

//     public BreachRecordEntity getBreachById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     public List<BreachRecordEntity> getBreachesByShipment(Long shipmentId) {
//         return repository.findByShipmentId(shipmentId);
//     }

//     public List<BreachRecordEntity> getAllBreaches() {
//         return repository.findAll();
//     }
// }
