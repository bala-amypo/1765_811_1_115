package com.example.demo.repository;

import com.example.demo.entity.ShipmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRecordRepository extends JpaRepository<ShipmentRecord, Long> {
    // Custom queries if needed
}
