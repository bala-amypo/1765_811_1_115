package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
public interface BreachRecordRepository extends JpaRepository<BreachRecord, Long> {
    List<BreachRecord> findByShipmentId(Long shipmentId);
}