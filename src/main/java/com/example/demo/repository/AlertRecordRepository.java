package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;

@Repository
public interface AlertRecordRepository extends JpaRepository<AlertRecord, Long> {
    List<AlertRecord> findByShipmentId(Long shipmentId);
}
