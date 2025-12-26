// File: src/main/java/com/example/demo/repository/BreachRecordRepository.java
package com.example.demo.repository;

import com.example.demo.entity.BreachRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreachRecordRepository extends JpaRepository<BreachRecord, Long> {
    List<BreachRecord> findByShipmentId(Long shipmentId);
    Optional<BreachRecord> findById(Long id);
}